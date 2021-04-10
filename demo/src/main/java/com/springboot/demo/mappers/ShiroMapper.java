package com.springboot.demo.mappers;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ShiroMapper extends BaseMapper<User> {
    @Insert("insert into t_user values(#{id},#{username},#{password},#{salt})")
    void save(User user);

    @Select("select * from t_user where username = #{username}")
    User findByName(String name);
}
