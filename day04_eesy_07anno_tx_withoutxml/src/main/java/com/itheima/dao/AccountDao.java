package com.springcurd.test.dao;

import com.itheima.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    Account findById(Integer id);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void delAccount(Integer id);
}
