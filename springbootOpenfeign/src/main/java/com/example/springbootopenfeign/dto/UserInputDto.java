package com.example.springbootopenfeign.dto;

import lombok.Data;

@Data
public class UserInputDto {
    private String username;
    private String password;
    private String name;
    private String description;
}
