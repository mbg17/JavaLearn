package com.springcloud.consul.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsulOrderController {
    @Autowired
    private RestTemplate restTemplate;

    private final String INVOKE_URL ="http://spring-consul-payment";

    @GetMapping("/order/consul/get")
    public String getHost(){
        String message = restTemplate.getForObject(INVOKE_URL+"/consul/get",String.class);
        return message;
    }
}
