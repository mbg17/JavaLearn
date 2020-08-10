package com.springtest.test;

import com.springcurd.test.configuration.SpringConfig;
import com.springcurd.test.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class junit {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer("2","3",1000F);
//        AccountService accountService = applicationContext.getBean("proxyAccountService", AccountService.class);
//        System.out.println(accountService);
//        Account byId = accountService.findById(2);
//        System.out.println(byId);
//        List<Account> all = accountDao.findAll();
//        System.out.println(all);
//        accountDao.insertAccount(byId);
    }
}
