package com.mbg17.service.impl;

import com.mbg17.dao.AccountDao;
import com.mbg17.domain.Account;
import com.mbg17.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(propagation= Propagation.SUPPORTS,readOnly=true)
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    @Override
    public void saveAccount(Account account) {
        accountDao.save(account);
    }
}
