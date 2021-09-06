package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.dto.BugInputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "bugs",url = "localhost:8000")
public interface BugService {
    @GetMapping("/getBugs")
    ResponseData getBugs();

    @PostMapping("/addBug")
    ResponseData addBug(BugInputDto bugInputDto);

    @GetMapping("/getBugs/{id}")
    ResponseData getBugById(Integer id);

    @DeleteMapping("/deleteBug/{id}")
    ResponseData deleteBug(Integer id);

    @PutMapping("/updateBug")
    ResponseData updateBug(BugInputDto bugInputDto);
}
