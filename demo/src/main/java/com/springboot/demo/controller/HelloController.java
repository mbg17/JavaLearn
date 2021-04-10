package com.springboot.demo.controller;

import com.springboot.demo.domain.Person;
import com.springboot.demo.exceptions.MyException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    private Person person;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @ResponseBody
    @GetMapping("/query")
    @RequiresRoles("admin")
    public Map<String,Object> map(){
        List<Map<String, Object>> list = jdbcTemplate.queryForList("select * FROM account");
        return list.get(0);
    }
    @ResponseBody
    @RequestMapping("/hello")
    public  String hello(@RequestParam("user") String user) throws MyException {
        if(user.equals("aaa")){
            throw new MyException("自定义异常","403");
        }
        return "Hello World";
    }
    @RequiresRoles("user")
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }

}
