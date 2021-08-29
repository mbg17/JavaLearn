package com.example.springboot.domain;

import lombok.Data;

@Data
public class ResponseData {
    private Integer code;
    private Object data;
    private String msg;

    public ResponseData() {
    }

    public ResponseData(Object data) {
        this.data = data;
    }

}
