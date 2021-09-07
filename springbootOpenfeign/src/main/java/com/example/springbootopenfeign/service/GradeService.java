package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.dto.GradeInputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "grades", url = "localhost:8000")
public interface GradeService {
    @GetMapping("/getGrades")
    ResponseData getGrades();

    @GetMapping("/getGradeById/{id}")
    ResponseData getGradeById(@PathVariable("id") Integer id);

    @PostMapping("/addGrade")
    ResponseData addGrade(@RequestBody GradeInputDto gradeInputDto);

    @DeleteMapping("/deleteGrade/{id}")
    ResponseData deleteGrade(@PathVariable("id") Integer id);

    @PutMapping("/updateGrade/{id}")
    ResponseData updateGrade(@RequestBody GradeInputDto gradeInputDto);
}
