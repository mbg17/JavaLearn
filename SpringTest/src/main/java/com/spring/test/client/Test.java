package com.spring.test.client;

import com.spring.test.dao.AccountDao;
import com.spring.test.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        // 使用set注入
        AccountService accountService1 = applicationContext.getBean("accountSet", AccountService.class);
        accountService1.saveAccount();
        // 使用工厂类注入
        AccountService accountService = applicationContext.getBean("accountServiveFactory", AccountService.class);
        accountService.saveAccount();
        // 使用工厂类静态方法注入
        AccountService accountService2 = applicationContext.getBean("accountServiceStatice", AccountService.class);
        accountService2.saveAccount();
        // 使用构造方法注入
        AccountService accountService4 = applicationContext.getBean("accountService", AccountService.class);
        accountService4.saveAccount();
        // 使用注解方式注入
        AccountDao accountDao = applicationContext.getBean("accountDao", AccountDao.class);
        System.out.println(accountDao);
        accountDao.saveAccount();
    }
}
