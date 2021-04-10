package com.springcloud.zookeeper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ZookeeperOrderController {
    @Resource
    private RestTemplate restTemplate;

    private final String INVOKE_URL = "http://payment";
    @GetMapping("/order/zookeeper/get")
    public String getHost(){
        String message = restTemplate.getForObject(INVOKE_URL+"/zookeeper/get",String.class);
        return message;
    }
}
