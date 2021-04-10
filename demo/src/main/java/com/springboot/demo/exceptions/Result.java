package com.springboot.demo.exceptions;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
@Data
@Builder
public class Result implements Serializable {
    private String code;
    private String message;
    private String time;
    private Object data;

//    public Result(String code, String message, String time) {
//        this.code = code;
//        this.message = message;
//        this.time = time;
//        this.data = "";
//    }

    @Tolerate
    public Result() {
        this.time = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
