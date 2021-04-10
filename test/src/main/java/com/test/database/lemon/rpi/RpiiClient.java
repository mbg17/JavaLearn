package com.test.database.lemon.rpi;

import com.lemon.rpm.entries.Student;
import com.lemon.rpm.service.StudentService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

public class RpiiClient {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url = "rmi://127.0.0.1:9000/student";
        StudentService studentService = (StudentService) Naming.lookup(url);
        Student s = new Student();
        s.setId(7);
        s.setName("李四");
        s.setSex("女");
        studentService.insertStudent(s);
        List<Student> students = studentService.query();
        students.stream().forEach(item->{
            System.out.println(String.format("ID:%d,姓名：%s,性别:%s。",item.getId(),item.getName(),item.getSex()));
        });
        System.out.println(studentService.findById(7));
        studentService.deleteById(7);
    }
}
