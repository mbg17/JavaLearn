package com.example.springboot.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.domain.Bug;
import com.example.springboot.dto.BugOutDto;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@Mapper
public interface BugDao extends BaseMapper<Bug> {
    @Insert("insert into bug_version (bug_id,version_id) values (#{bugId},#{versionId})")
    void addBugVersions(@Param("bugId") Integer bugId,@Param("versionId") Integer versionId);

    @Results(id = "bugVersion",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "grade_id",property = "grade",one = @One(select = "com.example.springboot.dao.GradeDao.selectById",fetchType = FetchType.LAZY)),
            @Result(column = "id",property = "versions",many = @Many(select = "com.example.springboot.dao.VersionDao.getVersionsByBugId",fetchType = FetchType.LAZY)),
    })
    @Select("select * from bug")
    List<BugOutDto> getAllBugs();

    @ResultMap("bugVersion")
    @Select("select * from bug where id = #{id}")
    BugOutDto getBugById(Integer id);

    @Delete("delete from bug_version where bug_id = #{id}")
    void deleteVersions(Integer id);
}
