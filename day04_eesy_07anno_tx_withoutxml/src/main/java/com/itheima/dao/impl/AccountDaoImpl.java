package com.springcurd.test.dao.impl;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.springcurd.test.dao.AccountDao;
import com.springcurd.test.domain.Account;
import com.itheima.
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner runner;
    @Autowired
    private ConnectionUtils connectionUtils;

    @Override
    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getConnettion(), "select * from account", new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Account findById(Integer id) {
        try {
            return runner.query(connectionUtils.getConnettion(), "select * from account where id = ? ", new BeanHandler<Account>(Account.class), id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertAccount(Account account) {
        try{
            runner.update(connectionUtils.getConnettion(),"insert into account(uid,money)values(?,?)",account.getUid(),account.getMoney());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateAccount(Account account) {
        try{
            runner.update(connectionUtils.getConnettion(),"update account set uid=?,money=? where id=?",account.getUid(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delAccount(Integer id) {
        try{
            runner.update(connectionUtils.getConnettion(),"delete from account where id=?",id);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

