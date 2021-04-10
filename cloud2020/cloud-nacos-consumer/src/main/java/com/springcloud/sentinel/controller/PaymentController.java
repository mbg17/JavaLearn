package com.springcloud.sentinel.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "CLOUD-NACOS-PAYMENT")
public interface PaymentController {
    @GetMapping("/getport")
    String getPort();
}
