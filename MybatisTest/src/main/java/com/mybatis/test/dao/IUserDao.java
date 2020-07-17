package com.mybatis.test.dao;

import com.mybatis.test.domain.User;

import java.util.List;

public interface IUserDao {
    List<User> findAll();
}
