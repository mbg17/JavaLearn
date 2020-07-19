package com.curd.test;

import com.curd.dao.RoleDao;
import com.curd.dao.UserDao;
import com.curd.domain.QueryVo;
import com.curd.domain.Role;
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

public class RoleTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private RoleDao mapper;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(RoleDao.class);
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
        List<Role> all = mapper.findAll();
        for (Role role : all) {
            System.out.println(role);
        }
    }

}
