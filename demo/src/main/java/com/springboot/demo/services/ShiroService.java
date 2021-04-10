package com.springboot.demo.services;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.springboot.demo.domain.User;
import com.springboot.demo.entities.Employee;
import com.springboot.demo.entities.EmployeeTwo;
import com.springboot.demo.mappers.EmployeeMapper;
import com.springboot.demo.mappers.ShiroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShiroService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    private ShiroMapper shiroMapper;

    public void save(User user) {
        shiroMapper.insert(user);
    }

    public User findByName(String name) {
        return shiroMapper.findByName(name);
    }

    @Cacheable(cacheNames = {"emp"},unless = "#result==null")
    public EmployeeTwo getEmpById(Integer id){
        return employeeMapper.getEmpById(id);
    }

    public void test(){
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<Employee>();
        UpdateWrapper<Employee> objectUpdateWrapper = new UpdateWrapper<Employee>();

    }
}
