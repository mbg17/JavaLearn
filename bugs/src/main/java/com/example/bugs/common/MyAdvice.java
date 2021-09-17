package com.example.bugs.common;

import com.example.bugs.exceptions.RoleException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyAdvice {
    @ExceptionHandler(RoleException.class)
    public Result roleController(RoleException e) {
        return new Result(500, null, e.getMessage());
    }
}
