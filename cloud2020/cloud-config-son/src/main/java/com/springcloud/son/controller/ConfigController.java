package com.springcloud.son.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// 通过暴露监控点可以通过post请求手动刷新配置文件
@RefreshScope
@RestController
public class ConfigController {
    @Value("${congfig.info}")
    private String config;

    @GetMapping("/config")
    public String getConfig(){
        return config;
    }
}
