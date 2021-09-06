package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "logs",url = "localhost:8000")
public interface LogService {
    @GetMapping("/logs")
    List<Log> logs();
}
