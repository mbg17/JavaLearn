package com.springboot.demo.services;

import com.springboot.demo.entities.EmployeeTwo;
import com.springboot.demo.mappers.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    @Cacheable(cacheNames = {"emp"},unless = "#result==null")
    public EmployeeTwo getEmpById(Integer id){
        return employeeMapper.getEmpById(id);
    }
}
