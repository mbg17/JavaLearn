package com.parent.service;

import com.parent.domain.Account;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AccountService {
    List<Account> findAll();
}
