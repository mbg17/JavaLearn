package com.springboot.demo.exceptions;

/**
 * 自定义异常类
 */
public class MyException extends Exception{
    private String code;
    public MyException() {
        super("我的异常");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MyException(String message, String code) {
        super(message);
        this.code = code;
    }
}
