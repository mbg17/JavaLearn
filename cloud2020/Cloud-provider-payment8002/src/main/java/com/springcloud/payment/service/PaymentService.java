package com.springcloud.payment.service;

import com.springcloud.payment.domain.Payment;

public interface PaymentService {
    Integer save(Payment payment);

    Payment findById(Integer id);
}
