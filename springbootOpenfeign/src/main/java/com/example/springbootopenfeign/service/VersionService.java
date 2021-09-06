package com.example.springbootopenfeign.service;

import com.example.springbootopenfeign.domain.ResponseData;
import com.example.springbootopenfeign.dto.VersionDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "versions", url = "localhost:8000")
public interface VersionService {
    @GetMapping("/versions")
    ResponseData getList();

    @PostMapping("/addVersion")
    ResponseData addVersion(VersionDto versionDto);

    @PutMapping("/updateVersion")
    ResponseData updateVersion(VersionDto versionDto);

    @DeleteMapping("/deleteVersion/{id}")
    ResponseData deleteVersion(Integer id);

    @GetMapping("/getVersionById/{id}")
    ResponseData getVersionById(Integer id);
}
