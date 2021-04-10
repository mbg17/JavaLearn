package com.example.bugs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bugs.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    void modifyVersion(HashMap<String, Object> hashMap);
}
