package com.example.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class VersionDto {
    private Integer id;
    private String name;
    private String description;
}
