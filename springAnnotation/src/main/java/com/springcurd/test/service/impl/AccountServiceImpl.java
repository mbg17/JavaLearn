package com.springcurd.test.service.impl;

import com.springcurd.test.dao.AccountDao;
import com.springcurd.test.domain.Account;
import com.springcurd.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("accountService")
@Transactional(propagation= Propagation.REQUIRED,readOnly=true)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    @Override
    public void insertAccount(Account account) {
        accountDao.insertAccount(account);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    @Override
    public void delAccount(Integer id) {
        accountDao.delAccount(id);
    }

    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //2.1根据名称查询转出账户
        Account source = accountDao.findById(2);
        //2.2根据名称查询转入账户
        Account target = accountDao.findById(3);
        //2.3转出账户减钱
        source.setMoney(source.getMoney() - money);
        //2.4转入账户加钱
        target.setMoney(target.getMoney() + money);
        //2.5更新转出账户
        accountDao.updateAccount(source);

        int i = 1 / 0;

        //2.6更新转入账户
        accountDao.updateAccount(target);
        //3.提交事务
    }
}
