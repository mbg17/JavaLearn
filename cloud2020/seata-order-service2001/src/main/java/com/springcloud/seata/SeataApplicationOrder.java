package com.springcloud.seata;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
//@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@MapperScan("com.springcloud.seata.dao")
public class SeataApplicationOrder {
    public static void main(String[] args) {
        SpringApplication.run(SeataApplicationOrder.class,args);
    }
}
