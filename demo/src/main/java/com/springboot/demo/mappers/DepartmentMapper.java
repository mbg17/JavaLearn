package com.springboot.demo.mappers;

import com.springboot.demo.entities.Department;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

//指定这是一个操作数据库的mapper
@Repository
@Mapper
public interface DepartmentMapper {

    @Select("select * from department where id = #{id}")
    Department findById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into department(departmentName) values (#{departmentName})")
    void savaDep(Department department);

    @Update("update department set departmentName=#{departmentName} where id = #{id}")
    void updateDep(Department department);

    @Delete("delete from department where id = #{id}")
    void delDep(Integer id);
}
