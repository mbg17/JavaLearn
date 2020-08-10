package com.springcurd.test.service;

import com.springcurd.test.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(Integer id);

    void insertAccount(Account account);

    void updateAccount(Account account);

    void delAccount(Integer id);
}
