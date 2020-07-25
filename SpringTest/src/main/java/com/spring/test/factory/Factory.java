package com.spring.test.factory;

import com.spring.test.service.AccountService;
import com.spring.test.service.impl.AccountServiceImpl;

/**
 * 模拟jar包方式
 */
public class Factory {
    public AccountService getAccountService(){
        return new AccountServiceImpl();
    }

    public static AccountService getAccountServiceStatic(){
        return new AccountServiceImpl();
    }
}
