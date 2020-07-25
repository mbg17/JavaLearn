package com.spring.test.service.impl;

import com.spring.test.dao.AccountDao;
import com.spring.test.dao.impl.AccountDaoImpl;
import com.spring.test.service.AccountService;

import java.util.*;

public class AccountServiceImpl implements AccountService {
    private String name;
    private Integer age;
    private Date birthday;
    private String[] myStrs;
    private ArrayList myList;
    private Set<String> mySet;
    private Map<String,String> myMap;
    private Properties myProps;

    public AccountServiceImpl() {
    }

    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setMyStrs(String[] myStrs) {
        this.myStrs = myStrs;
    }

    public void setMyList(ArrayList myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyProps(Properties myProps) {
        this.myProps = myProps;
    }

    private AccountDao accountDao = new AccountDaoImpl();
    @Override
    public void saveAccount() {
        System.out.println(name+":"+age+":"+birthday+":"+myList+":"+myMap+":"+myProps+":"+mySet+":"+Arrays.toString(myStrs));
    }
}
