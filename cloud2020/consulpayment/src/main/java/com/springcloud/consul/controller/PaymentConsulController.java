package com.springcloud.consul.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentConsulController {
    @Value("${server.port}")
    private String host;

    @GetMapping("/consul/get")
    public String getHost(){
        return host+ UUID.randomUUID().toString();
    }
}
