package com.springboot.demo.controller;

import com.springboot.demo.domain.User;
import com.springboot.demo.mappers.ShiroMapper;
import com.springboot.demo.services.ShiroService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ShiroController {
    @Autowired
    private ShiroService shiroService;
    @Autowired
    private ShiroMapper shiroMapper;
    @PostMapping("/register")
    public void save(User user){
        String salt = getSalt(8);
        //2.将随机盐保存到数据
        user.setSalt(salt);
        //3.明文密码进行md5 + salt + hash散列
        Md5Hash md5Hash = new Md5Hash(user.getPassword(),salt,1024);
        user.setPassword(md5Hash.toHex());
        shiroService.save(user);
    }

    @PostMapping("/login")
    public String login(String username,String password) throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.login(new UsernamePasswordToken(username,password));
        return "success";
    }

    @GetMapping("/logout")
    public String logout() throws Exception {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "success";
    }


    @GetMapping("/del")
    public String del() throws Exception {
        shiroMapper.deleteById(7);
        return "success";
    }
    public static String getSalt(int n){
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char aChar = chars[new Random().nextInt(chars.length)];
            sb.append(aChar);
        }
        return sb.toString();
    }
}
