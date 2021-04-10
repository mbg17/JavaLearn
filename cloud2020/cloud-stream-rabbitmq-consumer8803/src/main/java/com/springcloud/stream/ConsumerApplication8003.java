package com.springcloud.stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication8003 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication8003.class,args);
    }
}
