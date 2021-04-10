package com.springcloud.order.controller;

import com.springcloud.order.service.PaymentService;
import com.springcloud.payment.domain.Payment;
import com.springcloud.payment.result.CommentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class OrderFrignController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/customer/payment/{id}")
    public CommentResult findById(@PathVariable("id") Integer id){
        return paymentService.findById(id);
    }

    @PostMapping("/customer/payment/save")
    public CommentResult save(Payment payment){
        return paymentService.save(payment);
    }

    @GetMapping("/customer/payment/lb")
    public String getLb(){
        return paymentService.lb();
    }
}
