package com.heima.ssm.controller;

import com.heima.ssm.domain.SysLog;
import com.heima.ssm.service.SysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private SysLogService sysLogService;

    //开始时间
    private Date visitTime;
    //访问的类
    private Class clazz;
    //访问的方法
    private Method method;

    /**
     * Pointcut切入点方法（配置切入点方法的路径）
     */
    @Pointcut("execution(* com.heima.ssm.controller.*.*(..))")
    public void pt() {
    }

    /**
     * @param pjp
     * @return
     * @After():最终通知
     * @AfterReturning():后置通知
     * @AfterThrowing():异常通知
     * @Around():全局通知
     * @Before():前置通知
     */
    @Before("pt()")
    public void doBefore(JoinPoint pjp) {
        try {
            //当前时间就是开始访问的时间
            visitTime = new Date();
            //具体要访问的类
            clazz = pjp.getTarget().getClass();
            //获取访问的方法的名称
            String methodName = pjp.getSignature().getName();
            //获取访问的方法的参数
            Object[] args = pjp.getArgs();
            //获取具体执行的方法的Method对象
            if (args == null || args.length == 0) {
                //只能获取无参数的方法
                method = clazz.getMethod(methodName);
            } else {
                Class[] classArgs = new Class[args.length];
                for (int i = 0; i < args.length; i++) {
                    classArgs[i] = args[i].getClass();
                }
                method = clazz.getMethod(methodName, classArgs);
            }

        } catch (Throwable t) {
            //5.回滚操作
            throw new RuntimeException(t);
        }
    }

    @After("pt()")
    public void doAfter() throws Exception {
        try {
            long time = System.currentTimeMillis() - visitTime.getTime(); //获取访问的时长
            String url = "";
            //获取url
            if (clazz != null && method != null && clazz != LogAop.class) {
                //1.获取类上的@RequestMapping("/orders")
                RequestMapping classAnnotation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
                if (classAnnotation != null) {
                    String[] classValue = classAnnotation.value();
                    //2.获取方法上的@RequestMapping(xxx)
                    RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                    if (methodAnnotation != null) {
                        String[] methodValue = methodAnnotation.value();
                        url = classValue[0] + methodValue[0];
                        //获取访问的ip
                        String ip = request.getRemoteAddr();
                        //获取当前操作的用户
                        //从上下文中获了当前登录的用户
                        SecurityContext context = SecurityContextHolder.getContext();
                        User user = (User) context.getAuthentication().getPrincipal();
                        String username = user.getUsername();
                        //将日志相关信息封装到SysLog对象
                        SysLog sysLog = new SysLog();
                        //执行时长
                        sysLog.setExecutionTime(time);
                        sysLog.setIp(ip);
                        sysLog.setMethod("[类名] " + clazz.getName() + "[方法名] " + method.getName());
                        sysLog.setUrl(url);
                        sysLog.setUsername(username);
                        sysLog.setVisitTime(visitTime);
                        //调用Service完成操作
                        sysLogService.save(sysLog);
                    }
                }
            }
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
