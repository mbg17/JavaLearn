package com.example.springboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.util.Date;

public class Log {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String method;
    private String args;
    private Date operation;
    private String response;

    public Log() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public Date getOperation() {
        return operation;
    }

    public void setOperation(Date operation) {
        this.operation = operation;
    }

    public Log(String method, String args, String response, Date operation) {
        this.method = method;
        this.args = args;
        this.response = response;
        this.operation = operation;
    }
}
