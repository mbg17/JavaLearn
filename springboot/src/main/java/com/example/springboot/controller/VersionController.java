package com.example.springboot.controller;

import com.example.springboot.domain.ResponseData;
import com.example.springboot.domain.Version;
import com.example.springboot.dto.VersionDto;
import com.example.springboot.service.VersionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Api(tags = {"版本接口"})
public class VersionController {
    @Resource
    private VersionService versionService;

    @ApiOperation(value = "版本列表", notes = "获取所有版本", httpMethod = "GET")
    @GetMapping("/versions")
    public ResponseData versions() {
        return versionService.getList();
    }

    @ApiOperation(value = "获取指定版本", notes = "获取指定版本", httpMethod = "GET")
    @GetMapping("/getVersionById/{id}")
    public ResponseData getVersionById(@PathVariable("id") Integer id) {
        return versionService.getVersionById(id);
    }

    @ApiOperation(value = "添加版本", notes = "添加版本", httpMethod = "POST")
    @PostMapping("/addVersion")
    public ResponseData addVersion(@RequestBody VersionDto versionDto) {
        return versionService.addVersion(versionDto);
    }

    @ApiOperation(value = "更新版本", notes = "添加版本", httpMethod = "PUT")
    @PutMapping("/updateVersion")
    public ResponseData updateVersion(@RequestBody VersionDto versionDto) {
        return versionService.updateVersion(versionDto);
    }

    @ApiOperation(value = "删除版本", notes = "删除版本", httpMethod = "DELETE")
    @DeleteMapping("/deleteVersion/{id}")
    public ResponseData deleteVersion(@PathVariable("id") Integer id) {
        return versionService.deleteVersion(id);
    }
}
