package com.mybatis.test.dao;

import com.mybatis.test.domain.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    @Select("select * from account")
    List<User> findAll();
}
