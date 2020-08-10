package com.mbg17.dao;

import com.mbg17.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public interface AccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Update("insert into account (name,money) value(#{name},#{money})")
    void save(Account account);
}
