package com.example.springboot.service;

import com.example.springboot.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {
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
