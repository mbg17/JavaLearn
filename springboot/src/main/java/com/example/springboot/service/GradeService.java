package com.example.springboot.service;

import com.example.springboot.domain.ResponseData;
import com.example.springboot.dto.GradeInputDto;

public interface GradeService {
    ResponseData getGrades();

    ResponseData getGradeById(Integer id);

    ResponseData addGrade(GradeInputDto gradeInputDto);

    ResponseData deleteGrade(Integer id);

    ResponseData updateGrade(GradeInputDto gradeInputDto);
}
