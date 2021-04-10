package com.lemon.rpm.client;

import com.lemon.rpm.entries.Student;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url = "rmi://127.0.0.1:9000/student";
        StudentService studentService = (StudentService) Naming.lookup(url);
        List<Student> students = studentService.query();
        students.stream().forEach(item->{
            System.out.println(String.format("ID:%d,姓名：%s,性别:%s。",item.getId(),item.getName(),item.getSex()));
        });
        Student userEntity = new Student();
        userEntity.setId(7);
        userEntity.setName("李四");
        userEntity.setSex("女");
        studentService.insertStudent(userEntity);
    }
}
