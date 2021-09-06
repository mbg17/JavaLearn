package com.example.springboot.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseData implements Serializable {
    private Integer code;
    private Object data;
    private String msg;

    public ResponseData() {
    }

    public ResponseData(Object data) {
        this.data = data;
    }

}
