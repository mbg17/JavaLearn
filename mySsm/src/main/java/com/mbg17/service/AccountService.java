package com.mbg17.service;

import com.mbg17.domain.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    void saveAccount(Account account);
}
