package com.example.springboot.aop;

import com.example.springboot.dao.LogDao;
import com.example.springboot.domain.Log;
import com.example.springboot.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Date;

@Component
@Aspect
public class ServiceAop {
    @Resource
    private LogDao logDao;

    @Pointcut("execution(* com.example.springboot.service.impl.*.*(..))")
    public void pt() {
    }

    @Around("pt()")
    public Object aroundTransaction(ProceedingJoinPoint pjp) throws Throwable {
        Object invoke = null;
        Object[] args = pjp.getArgs();
        //得到方法执行所需的参数
        //1.开启事务
        invoke = pjp.proceed(args);
        //4.返回结果
        Log log = new Log(pjp.getSignature().getName(), Arrays.toString(args), invoke == null ? "null" : invoke.toString(), new Date(System.currentTimeMillis()));
        logDao.insert(log);
        return invoke;
    }
}
