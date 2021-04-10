package com.example.test.AutoConfiguration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(MyProperties.class)
public class MyAutoConfiguration {
    private MyProperties myProperties;

    @Bean
    public My myStarter(){
        My my = new My();
        my.setAge(myProperties.getAge());
        my.setName(myProperties.getName());
        return my;
    }

}
