package com.springcloud.payment.service.impl;

import com.springcloud.payment.Dao.PaymentDao;
import com.springcloud.payment.domain.Payment;
import com.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public Integer save(Payment payment) {
        return paymentDao.save(payment);
    }

    @Override
    public Payment findById(Integer id) {
        return paymentDao.findById(id);
    }
}
