package com.curd.dao;

import com.curd.domain.Account;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有
     */
    @Select("select * from account")
    List<Account> findAll();

    /**
     * 一对一注解开发
     */
    @Select("select * from account")
    @Results(id="accountUser",value = {
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "money",column = "money"),
            @Result(property = "user",column = "uid",one = @One(
                    select = "com.curd.dao.UserDao.findById",fetchType = FetchType.EAGER
            ))}
    )
    List<Account> findAllByUser();

    /**
     * 查询单个
     */
    @Select("select * from account where uid = #{uid}")
    List<Account> findAllByUserId(Integer uid);

    /**
     * 删除账户
     */
    @Delete("delete from account where uid = #{uid}")
    void deleteAccount(Integer uid);

    /**
     * 更新账户
     */
    @Update("update account set money=#{money} from account where uid = #{id}")
    void updateAccount(Account account);

    /**
     * 创建账户
     */
    @Update("insert into account (id,uid,money) values(#{id},#{uid},#{money})")
    void insertAccount(Account account);
}
