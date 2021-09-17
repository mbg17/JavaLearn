package com.example.bugs.aop;

import com.example.bugs.annocation.HasRole;
import com.example.bugs.domain.User;
import com.example.bugs.exceptions.RoleException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * aop鉴权
 */
@Component
@Aspect
public class RoleAop {
    @Resource
    private HttpSession httpSession;

    @Pointcut("execution(* com.example.bugs.controller.*.*(..))")
    public void pt() {
    }

    @Around("pt()")
    public Object aroundTransaction(ProceedingJoinPoint pjp) throws Throwable {
        Object invoke = null;
        Object[] args = pjp.getArgs();
        HasRole cRoles = pjp.getTarget().getClass().getAnnotation(HasRole.class);
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method targetMethod = methodSignature.getMethod();
        boolean annotationPresent = targetMethod.isAnnotationPresent(HasRole.class);
        User user = (User) httpSession.getAttribute("user");
        if (user == null && (annotationPresent || cRoles != null)) {
            throw new RoleException("用户未登录");
        }
        if (cRoles != null) {
            if (!checkRoles(cRoles.roles(), user.getRoles())) {
                throw new RoleException("权限不足，无法访问");
            }
        }
        if (annotationPresent) {
            String roles = targetMethod.getAnnotation(HasRole.class).roles();
            if (!checkRoles(roles, user.getRoles())) {
                throw new RoleException("权限不足，无法访问");
            }
        }
        invoke = pjp.proceed(args);
        return invoke;
    }

    public boolean checkRoles(String hasRole, String roles) {
        String[] h = hasRole.split(",");
        String[] r = roles.split(",");
        Arrays.sort(h);
        Arrays.sort(r);
        int hi = 0;
        int ri = 0;
        while (hi < h.length && ri < r.length) {
            if (h[hi].equalsIgnoreCase(r[ri])) {
                hi++;
            }
            ri++;
        }
        return hi == h.length;
    }
}
