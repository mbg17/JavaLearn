package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.dto.GradeInputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "grades",url = "localhost:8000")
public interface GradeService {
    @GetMapping("/getGrades")
    ResponseData getGrades();

    @GetMapping("/getGradeById/{id}")
    ResponseData getGradeById(Integer id);

    @PostMapping("/addGrade")
    ResponseData addGrade(GradeInputDto gradeInputDto);

    @DeleteMapping("/deleteGrade/{id}")
    ResponseData deleteGrade(Integer id);

    @PutMapping("/updateGrade/{id}")
    ResponseData updateGrade(GradeInputDto gradeInputDto);
}
