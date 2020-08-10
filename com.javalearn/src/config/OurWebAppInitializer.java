package com.mbg17.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class OurWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };        //指定Web配置类
    }

    @Override
    protected String[] getServletMappings() {//将 DispatcherServlet 映射到 "/" 路径
        return new String[] { "/" };
    }
}
