package com.mbg17.exception;

public class MyReport extends Exception {
    private String msg;

    public MyReport(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
