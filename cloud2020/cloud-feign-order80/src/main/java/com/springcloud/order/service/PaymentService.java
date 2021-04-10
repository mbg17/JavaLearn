package com.springcloud.order.service;

import com.springcloud.payment.domain.Payment;
import com.springcloud.payment.result.CommentResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
    @GetMapping("/payment/{id}")
    public CommentResult findById(@PathVariable("id") Integer id);

    @PostMapping("/payment/save")
    public CommentResult save(@RequestBody Payment payment);

    @GetMapping("/payment/lb")
    public String lb();
}
