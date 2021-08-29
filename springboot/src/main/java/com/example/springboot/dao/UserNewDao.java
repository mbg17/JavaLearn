package com.example.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.domain.UserNew;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserNewDao extends BaseMapper<UserNew> {
}
