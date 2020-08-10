package com.mbg17.service.impl;

import com.mbg17.dao.AccountDao;
import com.mbg17.domain.Account;
import com.mbg17.service.AccountSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AccountServiceImpl implements AccountSercive {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        System.out.println("start findall");
        return accountDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED,readOnly = false)
    public void save(Account account) {
        System.out.println("start save");
        accountDao.save(account);
    }
}
