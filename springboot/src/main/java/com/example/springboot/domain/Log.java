package com.example.springboot.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@ApiModel(value = "com.examples.springboot.daomain.User", description = "用户实体类")
public class Log {
    @ApiModelProperty(value = "ID")
    @TableId(type = IdType.AUTO)
    private Integer id;
    @ApiModelProperty(value = "方法名")
    private String method;
    @ApiModelProperty(value = "参数")
    private String args;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "操作时间")
    private Date operation;
    @ApiModelProperty(value = "响应结果")
    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

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
