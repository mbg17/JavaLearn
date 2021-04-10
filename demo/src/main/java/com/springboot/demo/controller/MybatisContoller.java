package com.springboot.demo.controller;

import com.springboot.demo.entities.Department;
import com.springboot.demo.entities.EmployeeTwo;
import com.springboot.demo.mappers.DepartmentMapper;
import com.springboot.demo.mappers.EmployeeMapper;
import com.springboot.demo.services.EmployeeService;
import com.springboot.demo.services.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class MybatisContoller {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    private ShiroService shiroService;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.findById(id);
    }

    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.savaDep(department);
        return department;
    }

    @GetMapping("/emp2/{id}")
    public EmployeeTwo getEmp(@PathVariable("id") Integer id){
        return shiroService.getEmpById(id);
    }

}
