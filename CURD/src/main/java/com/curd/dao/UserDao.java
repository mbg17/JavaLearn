package com.curd.dao;

import com.curd.domain.QueryVo;
import com.curd.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    /**
     * 一对多注解开发
    @Select("select * from user")
    @Results(id="userAccounts",value = {
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "sex",column = "sex"),
            @Result(property = "address",column = "address"),
            @Result(property = "accounts",column = "id",many = @Many(
                    select = "com.curd.dao.AccountDao.findAllByUserId",fetchType = FetchType.LAZY
            ))}
    )*/
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

    List<User> findUserRoles();
}
