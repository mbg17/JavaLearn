package com.springcloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Server7002Apllication {
    public static void main(String[] args) {
        SpringApplication.run(Server7002Apllication.class,args);
    }
}
