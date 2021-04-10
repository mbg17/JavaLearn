package com.springcurd.test.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.sql.SQLException;
import java.util.Arrays;

@Component("transactionUtils")
@Aspect
public class TransactionUtils {
    @Autowired
    private ConnectionUtils connectionUtils;

    /**
     * Pointcut切入点方法（配置切入点方法的路径）
     */
    @Pointcut("execution(* com.springcurd.test.service.impl.*.*(..))")
    public void pt(){
    }

    /**
     * @After():最终通知
     * @AfterReturning():后置通知
     * @AfterThrowing():异常通知
     * @Around():全局通知
     * @Before():前置通知
     * @param pjp
     * @return
     */
    @Around("pt()")
    public Object aroundTransaction(ProceedingJoinPoint pjp){
        Object invoke = null;
        try {
            //得到方法执行所需的参数
            Object[] args = pjp.getArgs();
            //1.开启事务
            this.beginTransaction();
            //明确调用业务层方法（切入点方法）
            invoke = pjp.proceed(args);
            //3.提交事务
            this.commit();
            //4.返回结果
            return invoke;
        }catch (Throwable t){
            //5.回滚操作
            this.rollback();
            throw new RuntimeException(t);
        }finally {
            //6.释放连接
            this.close();
        }
    }

    public void beginTransaction(){
        try {
            connectionUtils.getConnettion().setAutoCommit(false);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getConnettion().rollback();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtils.getConnettion().commit();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void close(){
        try {
            connectionUtils.getConnettion().close();
            connectionUtils.removeConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
