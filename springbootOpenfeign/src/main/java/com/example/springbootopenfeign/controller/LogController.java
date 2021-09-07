package com.example.springbootopenfeign.controller;

import com.example.springbootopenfeign.domain.Log;
import com.example.springbootopenfeign.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = {"日志接口"})
public class LogController {
    @Resource
    private LogService logService;

    @ApiOperation(value = "日志列表", notes = "获取所有日志", httpMethod = "GET")
    @GetMapping("/logs")
    public List<Log> logs() {
        return logService.logs();
    }
}
