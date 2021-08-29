package com.example.springboot.utils;

import com.example.springboot.domain.ResponseData;

public class ResponseUtil {
    public static ResponseData success(Object data) {
        ResponseData objectResponseData = new ResponseData(data);
        objectResponseData.setCode(0);
        objectResponseData.setMsg("获取数据成功");
        return objectResponseData;
    }

    public static ResponseData fail() {
        ResponseData objectResponseData = new ResponseData();
        objectResponseData.setCode(0);
        objectResponseData.setMsg("获取数据失败");
        return objectResponseData;
    }
}
