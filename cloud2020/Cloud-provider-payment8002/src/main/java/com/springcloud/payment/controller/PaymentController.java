package com.springcloud.payment.controller;

import com.springcloud.payment.domain.Payment;
import com.springcloud.payment.result.CommentResult;
import com.springcloud.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String host;

    @GetMapping("/payment/{id}")
    public CommentResult findById(@PathVariable("id") Integer id){
        System.out.println(id);
        Payment byId = paymentService.findById(id);
        System.out.println(byId);
        if(byId!=null){
            return new CommentResult("200","成功查询",byId);
        }
        return new CommentResult("400","查询失败");
    }

    @PostMapping("/payment/save")
    public CommentResult save(@RequestBody Payment payment){
        Integer save = paymentService.save(payment);
        if(save>=0){
            return new CommentResult("200","添加成功",save);
        }
        return new CommentResult("400","添加失败",save);
    }

    @GetMapping("/payment/lb")
    public String lb(){
        return host;
    }
}
