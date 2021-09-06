package com.example.springboot.service;

import com.example.springboot.domain.ResponseData;
import com.example.springboot.domain.Version;
import com.example.springboot.dto.VersionDto;
import org.springframework.cache.annotation.Cacheable;


public interface VersionService {
    ResponseData getList();

    ResponseData addVersion(VersionDto versionDto);

    ResponseData updateVersion(VersionDto versionDto);

    ResponseData deleteVersion(Integer id);

    ResponseData getVersionById(Integer id);
}
