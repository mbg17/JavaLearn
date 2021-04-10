package com.springboot.demo.mappers;

import com.springboot.demo.entities.EmployeeTwo;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeMapper {

    EmployeeTwo getEmpById(Integer id);

    void insertEmp(EmployeeTwo employee);
}
