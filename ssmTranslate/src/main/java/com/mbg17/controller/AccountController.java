package com.mbg17.controller;

import com.mbg17.dao.AccountDao;
import com.mbg17.domain.Account;
import com.mbg17.service.AccountSercive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountSercive accountSercive;
    @RequestMapping("/findall")
    public String testFindAll(){
        List<Account> all = accountSercive.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
        return "success";
    }

    @RequestMapping("/save")
    public String testSave(Account account){
        accountSercive.save(account);
        return "success";
    }
}
