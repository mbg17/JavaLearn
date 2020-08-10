package com.mbg17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value={"msg"})
public class AnnoController {

    /**
     * 获取请求参数
     * @param username 是否必填
     * @return String
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name="username") String username){
        System.out.println("testRequestParam......");
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求体
     * @param body
     * @return String
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody(required = false) String body){
        System.out.println("执行了...");
        System.out.println(body);
        return "success";
    }

    /**
     * 获取占位符参数
     * @param id
     * @return String
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable(name = "id") String id){
        System.out.println("testPathVariable......");
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头
     * @param handler
     * @return String
     */
    @RequestMapping("/testRequestHandler")
    public String testRequestHandler(@RequestHeader(value="Accept") String handler){
        System.out.println("testRequestHandler......");
        System.out.println(handler);
        return "success";
    }

    /**
     * 获取指定cookie参数
     * @param cookie
     * @return String
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookie){
        System.out.println("testCookieValue......");
        System.out.println(cookie);
        return "success";
    }

    @ModelAttribute
    public void testModelAttribute(){
        System.out.println("testModelAttribute.....");
    }

    /**
     * SessionAttributes的注解
     * @return
     */
    @RequestMapping(value="/testSessionAttributes")
    public String testSessionAttributes(Model model){
        System.out.println("testSessionAttributes...");
        // 底层会存储到request域对象中
        model.addAttribute("msg","美美");
        return "success";
    }

    /**
     * 获取值
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap){
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除
     * @param status
     * @return
     */
    @RequestMapping(value="/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status){
        System.out.println("getSessionAttributes...");
        status.setComplete();
        return "success";
    }
}
