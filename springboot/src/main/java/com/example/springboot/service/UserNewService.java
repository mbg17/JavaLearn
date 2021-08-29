package com.example.springboot.service;

import com.example.springboot.domain.ResponseData;
import com.example.springboot.domain.UserNew;
import com.example.springboot.dto.UserInputDto;
import com.example.springboot.dto.UserLoginDto;

public interface UserNewService {
    UserNew login(UserLoginDto userLoginDto );

    ResponseData register(UserInputDto userInputDto);
}
