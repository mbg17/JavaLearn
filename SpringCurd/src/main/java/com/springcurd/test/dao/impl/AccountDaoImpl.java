package com.springcurd.test.dao.impl;

import com.springcurd.test.dao.AccountDao;
import com.springcurd.test.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl implements AccountDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Account> findAll() {
        String sql = "select * from account";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account findById(Integer id) {
        String sql = "select * from account where id=?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Account>(Account.class),id);
    }

    @Override
    public void insertAccount(Account account) {
        String sql = "insert into account(uid,money) values(?,?)";
        jdbcTemplate.update(sql,account.getUid(),account.getMoney());
    }

    @Override
    public void updateAccount(Account account) {
        String sql = "update account set uid=?,money=? where id=?";
        jdbcTemplate.update(sql,account.getUid(),account.getMoney(),account.getId());
    }

    @Override
    public void delAccount(Integer id) {
        String sql = "delete from account where id=?";
        jdbcTemplate.update(sql,id);
    }
}

