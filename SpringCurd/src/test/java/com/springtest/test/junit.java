package com.springtest.test;

import com.springcurd.test.dao.AccountDao;
import com.springcurd.test.domain.Account;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class junit {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        Account byId = accountDao.findById(2);
        System.out.println(byId);
        List<Account> all = accountDao.findAll();
        System.out.println(all);
//        accountDao.insertAccount(byId);
    }
}
