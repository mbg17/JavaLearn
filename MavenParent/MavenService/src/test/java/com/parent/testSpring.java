package com.parent;

import com.parent.domain.Account;
import com.parent.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testSpring {
    @Test
    public void testFindAll(){
        ApplicationContext spring = new ClassPathXmlApplicationContext("Spring/spring.xml");
        AccountService accountService = spring.getBean("accountService", AccountService.class);
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }
}
