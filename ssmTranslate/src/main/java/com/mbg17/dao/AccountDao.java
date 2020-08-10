package com.mbg17.dao;

import com.mbg17.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public interface AccountDao {
    @Select("select * from account")
    List<Account> findAll();

    @Select("insert into account (name,money) values (#{name},#{money})")
    void save(Account account);
}
