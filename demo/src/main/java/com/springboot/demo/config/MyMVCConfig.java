package com.springboot.demo.config;

import com.springboot.demo.Compents.MyInterceptors;
import com.springboot.demo.Compents.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
//@EnableWebMvc
public class MyMVCConfig implements WebMvcConfigurer{

    /**
     * 注册国际化bean
     * @param
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    /**
     * 此配置回合主配置类一同生效
     * @param
     */
    @Bean //将组件注册在容器
    public WebMvcConfigurer webMvcConfigurerAdapter(){
        WebMvcConfigurer adapter = new WebMvcConfigurer() {
            /**
             * 配置视图映射
             * @param registry
             */
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            /**
             * 配置拦截器
             * @param registry
             */
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                //super.addInterceptors(registry);
//                //静态资源；  *.css , *.js
//                //SpringBoot已经做好了静态资源映射
//                registry.addInterceptor(new MyInterceptors()).addPathPatterns("/**")
//                        .excludePathPatterns("/index.html","/","/user/login","/asserts/**","/webjars/**");
//            }
        };
        return adapter;
    }
}
