package com.parent.controller;

import com.parent.domain.Account;
import com.parent.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping("/findall")
    public String findAll() {
        System.out.println("findAll");
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        return "success";
    }
}
