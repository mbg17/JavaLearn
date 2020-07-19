package com.curd.dao;

import com.curd.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAll();

    List<Account>findAllByUser();
}
