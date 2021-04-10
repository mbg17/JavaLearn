package com.springcloud.nacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    private final String PAYMENT_URL = "http://CLOUD-NACOS-PAYMENT";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/getport")
    public String getPort(){
        return restTemplate.getForObject(PAYMENT_URL+"/getport",String.class);
    }

}
