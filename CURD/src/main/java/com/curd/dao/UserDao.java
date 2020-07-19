package com.curd.dao;

import com.curd.domain.QueryVo;
import com.curd.domain.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findById(Integer id);

    List<User> findByName(String name);

    void saveUser(User user);

    void delUser(Integer id);

    void updateUser(User user);

    Integer findTotal();

    List<User> findByUser(User user);

    List<User> findByList(List<Integer> list);

    List<User> findByQueryVo(QueryVo vo);
}
