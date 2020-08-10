package com.mbg17.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
//配置注解扫描的包路径
@ComponentScan( basePackages={"com.mbg17"},
        excludeFilters = { @ComponentScan.Filter(type= FilterType.ANNOTATION,value= EnableWebMvc.class)}
)
public class RootConfig {
}

