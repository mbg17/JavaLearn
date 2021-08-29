package com.example.springboot.aop;

import com.example.springboot.annocation.NotAop;
import com.example.springboot.dao.LogDao;
import com.example.springboot.domain.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;

/**
 * 测试11
 */
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
        NotAop annotation = pjp.getTarget().getClass().getAnnotation(NotAop.class);
        invoke = pjp.proceed(args);
        String response = "";
        if (annotation == null) {
            if (invoke instanceof List) {
                String typeName = invoke.getClass().getTypeName();
                response = ((List<?>) invoke).size() > 0 ? "List<" + ((List<?>) invoke).get(0).getClass().getName() + ">(" + ((List<?>) invoke).size() + ")" : "null";
            } else if (invoke instanceof HashMap) {
                String typeName = invoke.getClass().getTypeName();
                ArrayList<Map.Entry<?, ?>> list = new ArrayList<>(((HashMap) invoke).entrySet());
                response = list.size() > 0 ? "Map<" + list.get(0).getKey().getClass().getName() + "," + list.get(0).getValue().getClass().getName() + ">" + list.size() : "null";
            } else {
                response = invoke == null ? "null" : invoke.toString().length()>400?invoke.getClass().getPackageName():invoke.toString();
            }
            Log log = new Log(pjp.getSignature().getName(), Arrays.toString(args).length()>100?args.getClass().getPackageName():Arrays.toString(args), response, new Date(System.currentTimeMillis()));
            logDao.insert(log);
        }
        return invoke;
    }
}
