package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.dto.VersionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;


@FeignClient(name = "versions", url = "localhost:8000")
public interface VersionService {
    @GetMapping("/versions")
    ResponseData getList();

    @PostMapping("/addVersion")
    ResponseData addVersion(@RequestBody VersionDto versionDto);

    @PutMapping("/updateVersion")
    ResponseData updateVersion(@RequestBody VersionDto versionDto);

    @DeleteMapping("/deleteVersion/{id}")
    ResponseData deleteVersion(@PathVariable("id") Integer id);

    @GetMapping("/getVersionById/{id}")
    ResponseData getVersionById(@PathVariable("id") Integer id);
}
