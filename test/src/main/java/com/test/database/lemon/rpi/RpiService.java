package com.test.database.lemon.rpi;

import com.lemon.rpm.service.StudentService;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RpiService {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        //1、定义端口服务
        Registry registry = LocateRegistry.createRegistry(9000);

        //2、绑定服务
        StudentServiceImpl studentService = new StudentServiceImpl();
        registry.bind("student",studentService);
    }
}
