package com.example.bugs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bugs.domain.Version;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface VersionMapper extends BaseMapper<Version> {

    List<String> findAllVersion();

    void modifyVersion(HashMap<String, Object> hashMap);
}
