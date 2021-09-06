package com.example.springboot.service;

import com.example.springboot.domain.ResponseData;
import com.example.springboot.dto.BugInputDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

public interface BugService {
    ResponseData getBugs();

    ResponseData addBug(BugInputDto bugInputDto);

    ResponseData getBugById(Integer id);

    ResponseData deleteBug(Integer id);

    ResponseData updateBug(BugInputDto bugInputDto);
}
