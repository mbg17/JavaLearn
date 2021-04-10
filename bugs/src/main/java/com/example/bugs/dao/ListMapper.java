package com.example.bugs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bugs.domain.Lists;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ListMapper extends BaseMapper<Lists> {
    void addBug(HashMap<String, String> hashMap);

    List<HashMap<String, Integer>> getBugDetail();

    List<HashMap<String, Integer>> submitBugs();

    List<HashMap<String, Integer>> createBugs();

    List<String> hasVersion();

}
