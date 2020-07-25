package com.curd.test;

import com.curd.dao.UserDao;
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

public class UserTest {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserDao mapper;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        mapper = sqlSession.getMapper(UserDao.class);
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
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 查询所有用户
     */
    @Test
    public void testFindUserRoles() {
        List<User> all = mapper.findUserRoles();
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 根据id查询用户
     */
    @Test
    public void testFindById() {
        User byId = mapper.findById(41);
        System.out.println(byId);
    }

    /**
     * 模糊查询所有用户
     */
    @Test
    public void testFindByUsername() {
        List<User> byName = mapper.findByName("%王%");
        for (User user : byName) {
            System.out.println(user);
        }
    }

    /**
     * 保存用户并返回id
     */
    @Test
    public void testSaveUser() {
        User user = new User();
        user.setAddress("test save");
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setSex("M");
        user.setUsername("tsetSave");
        mapper.saveUser(user);
        System.out.println(user.getId());
    }

    /**
     * 根据id删除用户
     */
    @Test
    public void testDelUser() {
        mapper.delUser(49);
    }

    /**
     * 保存用户并返回id
     */
    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setAddress("test update");
        user.setBirthday(new Date(System.currentTimeMillis()));
        user.setSex("F");
        user.setUsername("tsetUpdate");
        user.setId(50);
        mapper.updateUser(user);
        System.out.println(user.getId());
    }

    @Test
    public void testFindTotal() {
        Integer total = mapper.findTotal();
        System.out.println(total);
    }

    @Test
    public void testFindByUser() {
        User user = new User();
        user.setUsername("老王");
        user.setSex("男");
        List<User> byUser = mapper.findByUser(user);
        for (User user1 : byUser) {
            System.out.println(user1);
        }
    }

    @Test
    public void testFindByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        List<User> byList = mapper.findByList(ids);
        for (User user : byList) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindByQueryVo() {
        QueryVo queryVo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(41);
        ids.add(42);
        ids.add(43);
        queryVo.setIds(ids);
        List<User> byList = mapper.findByQueryVo(queryVo);
        for (User user : byList) {
            System.out.println(user);
        }
    }
}
