package com.example.springboot.dto;

import lombok.Data;

import java.util.List;

@Data
public class BugInputDto {
    private Integer id;
    private String title;
    private Integer reportUserId;
    private Integer gradeId;
    private String description;
    private List<Integer> versions;
}
