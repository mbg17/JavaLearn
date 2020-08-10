package com.mbg17.controller;

import com.mbg17.domain.Account;
import com.mbg17.service.AccountService;
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
    public String findAll(){
        System.out.println("findAll");
        List<Account> all = accountService.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        return "list";
    }

    @RequestMapping("/save")
    public String save(Account account){
        System.out.println("save");
        accountService.saveAccount(account);
        return "list";
    }
}
