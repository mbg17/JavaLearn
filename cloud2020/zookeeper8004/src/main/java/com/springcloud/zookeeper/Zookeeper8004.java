package com.springcloud.zookeeper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Zookeeper8004 {
    public static void main(String[] args) {
        SpringApplication.run(Zookeeper8004.class,args);
    }
}
