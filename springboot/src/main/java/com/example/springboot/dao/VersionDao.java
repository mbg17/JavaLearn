package com.example.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.domain.Version;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface VersionDao extends BaseMapper<Version> {
    @Select("select v.id,v.name,v.description,v.create_by,v.create_time,v.update_by,v.update_time from version v left join bug_version bv on bv.version_id = v.id where bug_id = #{id}")
    List<Version> getVersionsByBugId(Integer id);
}
