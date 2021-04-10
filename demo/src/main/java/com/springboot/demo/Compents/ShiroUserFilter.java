package com.springboot.demo.Compents;

import lombok.SneakyThrows;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class ShiroUserFilter extends UserFilter {

    @SneakyThrows
    @Override
    protected void redirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
//        super.redirectToLogin(request, response);
        Map<String,String> map =new HashMap<>();
        map.put("code","500");
        map.put("message","验证失败");
        map.put("requestTime",new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(System.currentTimeMillis()));
        request.setAttribute("javax.servlet.error.status_code",500);
        request.setAttribute("response",map);
        request.getRequestDispatcher("/error").forward(request,response);
    }
}