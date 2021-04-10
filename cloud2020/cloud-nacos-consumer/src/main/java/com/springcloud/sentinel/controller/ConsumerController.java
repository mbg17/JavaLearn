package com.springcloud.sentinel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {
    @Resource
    private PaymentController paymentController;

    @GetMapping("/consumer/getport")
    public String getPort(){
        return paymentController.getPort();
    }
}
