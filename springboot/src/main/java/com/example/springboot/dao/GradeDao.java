package com.example.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.domain.Grade;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GradeDao extends BaseMapper<Grade> {

}
