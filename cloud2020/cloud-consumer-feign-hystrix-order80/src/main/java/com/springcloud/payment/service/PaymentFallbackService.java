package com.springcloud.payment.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK 超时";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut 超时";
    }

    @Override
    public String paymentCircuitBreaker(Integer id) {
        return "paymentCircuitBreaker 超时";
    }
}
