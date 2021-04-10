package com.springboot.demo.controller;

import com.springboot.demo.dao.DepartmentDao;
import com.springboot.demo.dao.EmployeeDao;
import com.springboot.demo.entities.Department;
import com.springboot.demo.entities.Employee;
import com.springboot.demo.mappers.ShiroMapper;
import com.springboot.demo.services.ShiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;

    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage( Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String saveEmp( Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String empDetail(@PathVariable("id") Integer id,Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        Collection<Department> departments = departmentDao.getDepartments();
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @PostMapping("/emp/{id}")
    public String delEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
