package com.example.demo.dao;

import com.example.demo.domain.Login;

@Mapper
public interface LoginDao {
    @Select("select * from login where name = #{name} and password = #{password}")
    Login login(String name,String password);

}
