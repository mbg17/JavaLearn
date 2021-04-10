package com.springcloud.son;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ConfigSonApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConfigSonApplication.class,args);
    }
}
