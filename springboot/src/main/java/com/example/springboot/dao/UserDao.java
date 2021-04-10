package com.example.springboot.dao;

import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao {
    @Select("select * from login")
    List<User> query();

    @Select("select * from login where id = #{id}")
    User findUserById(Integer id);

    @Delete("delete from login where id = #{id}")
    void deleteUserById(Integer id);

    @Insert("insert into login (username,password) values (#{username},#{password})")
    void addUser(User user);

    @Update("update login set username = #{username},password=#{password} where id = #{id}")
    void updateUser(User user);
}
