package com.springboot.stream.controller;

import com.springboot.stream.Service.SendMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RmbqSendMessageController {
    @Autowired
    private SendMessageProviderService sendMessageProviderService;

    @GetMapping("/sendMessage")
    public String send(){
        return sendMessageProviderService.send();
    }
}
