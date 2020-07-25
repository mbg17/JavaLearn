package com.curd.test;

import com.curd.dao.AccountDao;
import com.curd.dao.UserDao;
import com.curd.domain.Account;
import com.curd.domain.QueryVo;
import com.curd.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccountCurdTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao mapper;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(AccountDao.class);
    }

    @After
    public void destory() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        inputStream.close();
    }

    /**
     * 查询所有用户
     */
    @Test
    public void testFindAll() {
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAllUser() {
        List<Account> all = mapper.findAllByUser();
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void testInsert() {
        Account account = new Account();
        account.setId(4);
        account.setMoney(5000.00);
        account.setUid(42);
        mapper.insertAccount(account);
    }

    @Test
    public void testDelete() {
        mapper.deleteAccount(41);
    }
}
