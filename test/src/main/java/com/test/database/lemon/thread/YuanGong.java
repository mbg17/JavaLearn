package com.test.database.lemon.thread;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class YuanGong {
    public static void main(String[] args) {
        ArrayList<Domain> domains = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            domains.add(new Domain(i, "name" + i, i + "@qq.com"));
        }
        for (Domain domain : domains) {
            try {
                Thread.sleep(1000);
                new Thread(() -> {
                    System.out.println("给" + domain.getName() + "发送信息");
                    System.out.println(Thread.currentThread().getName() + ":" + domain.getName() + ":" + domain.getEmail());
                }).start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(30));
        for (Domain domain : domains) {
            try {
                Thread.sleep(1000);
                threadPoolExecutor.submit(new MyThread(domain));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread extends Thread {
    private Domain domain;

    public MyThread(Domain domain) {
        this.domain = domain;
    }

    @Override
    public void run() {
        System.out.println("给" + this.domain.getName() + "发信息");
        System.out.println(this.getName() + this.domain.getName() + this.domain.getEmail());
    }
}

//一、使用多线程模拟完成业务：主线程定义一个包含10个员工的ArrayList
//，员工信息包含ID、姓名、邮箱；使用多线程给每个员工推送邮件信息，
//        用System.out输出线程名、员工的姓名、邮箱
class Domain {
    private Integer id;
    private String name;
    private String email;

    public Domain(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Domain() {
    }

    @Override
    public String toString() {
        return "Domain{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
