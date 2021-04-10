package com.springcloud.nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
    @Value("${config.info}")
    private String info;

    @GetMapping("/getConfig")
    public String getConfig(){
        return info;
    }
}
