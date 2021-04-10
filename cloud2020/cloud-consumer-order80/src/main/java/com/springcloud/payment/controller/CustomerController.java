package com.springcloud.payment.controller;


import com.netflix.appinfo.InstanceInfo;
import com.springcloud.payment.compent.MyLb;
import com.springcloud.payment.domain.Payment;
import com.springcloud.payment.result.CommentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    public DiscoveryClient discoveryClient;

    @Resource
    private MyLb myLb;
    public static String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @GetMapping("/customer/payment/{id}")
    public CommentResult findById(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommentResult.class);
    }

    @PostMapping("/customer/payment/save")
    public CommentResult save(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/save",payment, CommentResult.class);
    }

    @GetMapping("/customer/payment/lb")
    public String getLb(){
        List<ServiceInstance> instancesById = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        ServiceInstance instance = myLb.getInstance(instancesById);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

}
