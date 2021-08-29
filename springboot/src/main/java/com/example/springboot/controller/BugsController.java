package com.example.springboot.controller;

import com.example.springboot.domain.ResponseData;
import com.example.springboot.dto.BugInputDto;
import com.example.springboot.service.BugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Delete;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = {"Bug接口"})
public class BugsController {
    @Resource
    private BugService bugService;

    @ApiOperation(value = "获取所有BUG", notes = "获取所有BUG", httpMethod = "GET")
    @GetMapping("/getBugs")
    public ResponseData getBugs(){
        return bugService.getBugs();
    }

    @ApiOperation(value = "获取指定BUG", notes = "获取指定BUG", httpMethod = "GET")
    @GetMapping("/getBugs/{id}")
    public ResponseData getBugById(@PathVariable("id") Integer id){
        return bugService.getBugById(id);
    }

    @ApiOperation(value = "添加bug", notes = "添加bug", httpMethod = "POST")
    @PostMapping("/addBug")
    public ResponseData addBug(@RequestBody BugInputDto bugInputDto){
        return bugService.addBug(bugInputDto);
    }

    @ApiOperation(value = "删除bug", notes = "删除bug", httpMethod = "DELETE")
    @DeleteMapping("/deleteBug/{id}")
    public ResponseData deleteBug(@PathVariable("id") Integer id){
        return bugService.deleteBug(id);
    }

    @ApiOperation(value = "修改bug", notes = "修改bug", httpMethod = "PUT")
    @PutMapping("/updateBug")
    public ResponseData updateBug(@RequestBody BugInputDto bugInputDto){
        return bugService.updateBug(bugInputDto);
    }

}
