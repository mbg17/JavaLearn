package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.domain.UserNew;
import com.example.springbootopenfeign.dto.UserInputDto;
import com.example.springbootopenfeign.dto.UserLoginDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "userNew",url = "localhost:8000")
public interface UserNewService {
    @PostMapping("/login")
    UserNew login(UserLoginDto userLoginDto);

    @PostMapping("/register")
    ResponseData register(UserInputDto userInputDto);
}
