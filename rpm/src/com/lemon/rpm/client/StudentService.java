package com.lemon.rpm.client;

import com.lemon.rpm.entries.Student;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentService extends UnicastRemoteObject implements com.lemon.rpm.service.StudentService {
    public StudentService() throws RemoteException {
    }

    private List<Student> students = new ArrayList<>();

    @Override
    public List<Student> query() throws RemoteException {
        return students;
    }

    @Override
    public Student findById(Integer integer) throws RemoteException {
        List<Student> collect = this.students.stream().filter(student -> student.getId().equals(integer)).collect(Collectors.toList());
        return collect.size() == 0 ? null : collect.get(0);
    }

    @Override
    public void insertStudent(Student student) throws RemoteException {
        this.students.add(student);
    }

    @Override
    public void deleteById(Integer integer) throws RemoteException {
        for (int i = 0; i < this.students.size(); i++) {
            if (students.get(i).getId().equals(integer)) {
                this.students.remove(i);
                break;
            }
        }
    }
}
