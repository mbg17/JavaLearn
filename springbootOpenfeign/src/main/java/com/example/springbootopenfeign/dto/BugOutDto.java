package com.example.springbootopenfeign.dto;

import com.example.springbootopenfeign.domain.Grade;
import com.example.springbootopenfeign.domain.Version;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@JsonIgnoreProperties(value = {"handler"})
public class BugOutDto implements Serializable {
    private Integer id;
    private String title;
    private Integer reportUserId;
    private Grade grade;
    private String description;
    private List<Version> versions;
}
