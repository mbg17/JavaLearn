package com.springboot.demo.controller;

import com.springboot.demo.exceptions.MyException;
import com.springboot.demo.exceptions.Result;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.SimpleFormatter;

/**
 * 自定义异常处理器，配合自定义的ErrorAttributes可实现自定义json或者页面返回
 */
@RestControllerAdvice
public class MyExceptionHandler {
    @ExceptionHandler({Exception.class})
    public Result myHandler(Exception e, HttpServletRequest request) {
        Result result;
        if (e instanceof UnknownAccountException || e instanceof IncorrectCredentialsException) {

            result=Result.builder().code("401")
                    .message("用户名或密码错误")
                    .time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()))
                    .build();
        } else if (e instanceof UnauthorizedException || e instanceof UnauthenticatedException) {
            result=Result.builder().code("402")
                    .message("登录超时或权限不足")
                    .time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()))
                    .build();
        } else if (e instanceof MyException) {
            result=Result.builder().code(((MyException) e).getCode())
                    .message(e.getMessage())
                    .time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()))
                    .build();
        } else {
            result=Result.builder().code("500")
                    .message(e.getMessage())
                    .time(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()))
                    .build();
        }
        return result;
    }
}
