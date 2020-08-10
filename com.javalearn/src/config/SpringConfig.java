package com.mbg17.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.mbg17.controller")
@EnableWebMvc
class SpringConfig {
    @Bean(name="internalResourceViewResolver")
    public InternalResourceViewResolver createInternalResourceViewResolver(){
        InternalResourceViewResolver in = new InternalResourceViewResolver();
        in.setPrefix("/WEB-INF/pages/");
        in.setSuffix(".jsp");
        return in;
    }
}
