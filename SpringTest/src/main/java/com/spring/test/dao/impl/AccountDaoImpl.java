package com.spring.test.dao.impl;

import com.spring.test.dao.AccountDao;
import com.spring.test.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Component;

import java.util.*;
@Component("accountDao")
public class AccountDaoImpl implements AccountDao {
    private String name;
    private Integer age;
    private Date birthday;
    @Autowired// 自动注入
    @Qualifier("accountSet") // 指定使用哪个bean自动注入
    private AccountService accountService;
    public AccountDaoImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public AccountDaoImpl() {
    }

    @Override
    public void saveAccount() {
        System.out.println("保存的账户");
        accountService.saveAccount();
        System.out.println(name+":"+age+":"+birthday+":"+accountService);
    }
}
