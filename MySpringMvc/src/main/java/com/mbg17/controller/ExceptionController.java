package com.mbg17.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/error")
public class ExceptionController {

    @RequestMapping(path = "/testException")
    public String testError(){
        int  i =1/0;
        return "success";
    }
}
