package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.dto.BugInputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "bugs",url = "localhost:8000")
public interface BugService {
    @GetMapping("/getBugs")
    ResponseData getBugs();

    @PostMapping("/addBug")
    ResponseData addBug(@RequestBody BugInputDto bugInputDto);

    @GetMapping("/getBugs/{id}")
    ResponseData getBugById(@PathVariable("id")Integer id);

    @DeleteMapping("/deleteBug/{id}")
    ResponseData deleteBug(@PathVariable("id") Integer id);

    @PutMapping("/updateBug")
    ResponseData updateBug(@RequestBody BugInputDto bugInputDto);
}
