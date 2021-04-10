package com.springboot.stream.Service.impl;

import com.springboot.stream.Service.SendMessageProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
public class SendMessageProviderServiceImpl implements SendMessageProviderService {
    @Resource
    @Qualifier("output")
    private MessageChannel messageChannel;

    @Override
    public String send() {
        String serial = UUID.randomUUID().toString();
        System.out.println(serial);
        messageChannel.send(MessageBuilder.withPayload(serial).build());
        return "ok";
    }
}
