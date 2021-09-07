package com.example.springbootopenfeign.controller;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.dto.GradeInputDto;
import com.example.springbootopenfeign.service.GradeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = {"缺陷等级接口"})
public class GradeController {
    @Resource
    private GradeService gradeService;

    @ApiOperation(value = "获取所有缺陷等级", notes = "获取所有缺陷等级", httpMethod = "GET")
    @GetMapping("/getGrades")
    public ResponseData getGrades() {
        return gradeService.getGrades();
    }

    @ApiOperation(value = "获取指定缺陷等级", notes = "获取指定缺陷等级", httpMethod = "GET")
    @GetMapping("/getGradeById/{id}")
    public ResponseData getGradeById(@PathVariable("id") Integer id) {
        return gradeService.getGradeById(id);
    }

    @ApiOperation(value = "添加缺陷等级", notes = "添加缺陷等级", httpMethod = "POST")
    @PostMapping("/addGrade")
    public ResponseData addGrade(@RequestBody GradeInputDto gradeInputDto) {
        return gradeService.addGrade(gradeInputDto);
    }

    @ApiOperation(value = "删除指定缺陷等级", notes = "删除指定缺陷等级", httpMethod = "DELETE")
    @DeleteMapping("/deleteGrade/{id}")
    public ResponseData deleteGrade(@PathVariable("id") Integer id) {
        return gradeService.deleteGrade(id);
    }

    @ApiOperation(value = "更新指定缺陷等级", notes = "更新指定缺陷等级", httpMethod = "PUT")
    @PutMapping("/updateGrade/{id}")
    public ResponseData updateGrade(@RequestBody GradeInputDto gradeInputDto) {
        return gradeService.updateGrade(gradeInputDto);
    }

}
