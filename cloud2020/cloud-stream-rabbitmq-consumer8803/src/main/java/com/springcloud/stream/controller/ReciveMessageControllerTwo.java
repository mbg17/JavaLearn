package com.springcloud.stream.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class ReciveMessageControllerTwo {

    @StreamListener(Sink.INPUT)
    public void recive(Message<String> message){
        String result = message.getPayload();
        System.out.println(result);
    }
}
