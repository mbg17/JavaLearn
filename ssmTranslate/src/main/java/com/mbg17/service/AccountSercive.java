package com.mbg17.service;

import com.mbg17.dao.AccountDao;
import com.mbg17.domain.Account;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountSercive {

    List<Account> findAll();

    void save(Account account);
}
