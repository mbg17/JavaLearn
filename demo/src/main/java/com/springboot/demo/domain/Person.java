package com.springboot.demo.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@ConfigurationProperties(prefix = "person")//指定映射到配置文件的那个信息
public class Person {
    private String name;
    private Integer age;
    private boolean boss;
    List<Object> pets;
    Map<Object,Object> test;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", boss=" + boss +
                ", pets=" + pets +
                ", test=" + test +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isBoss() {
        return boss;
    }

    public void setBoss(boolean boss) {
        this.boss = boss;
    }

    public List<Object> getPets() {
        return pets;
    }

    public void setPets(List<Object> pets) {
        this.pets = pets;
    }

    public Map<Object, Object> getTest() {
        return test;
    }

    public void setTest(Map<Object, Object> test) {
        this.test = test;
    }
}
