package com.test.database.lemon.annotation;

import com.test.database.translate.std.In;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class AnnotationTest {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        一、定义一个用户类，包括ID、用户名、密码、性别、年龄、银行存款等属性，属性都有gettter、setter方法，还包括构造方法(默认构造、接收所有属性参数构造）；普通方法取钱、存钱方法
//
//                二、使用反射列出第一点用户类的所有属性、构造方法、普通方法等
//
//                三、自定义银行存款限额的注解，银行存款只能在0-500000之间，且不能为空；在存钱、取钱时进行验证
//
//                四、使用用户类定义一个10个用户的集合，按银行存款降序输出用户的用户名+密码，如：张三_123456
//
//                五、完成课上所有的示例
        Class<Account> accountClass = Account.class;
        Arrays.stream(accountClass.getDeclaredMethods()).forEach(method -> System.out.println(method.getName()));
        Arrays.stream(accountClass.getConstructors()).forEach(constructor -> System.out.println(constructor.getName()));
        Arrays.stream(accountClass.getDeclaredFields()).forEach(field -> System.out.println(field.getName()));
        Account account = new Account();
        account.setMoney(1000);
        for (Field field : accountClass.getDeclaredFields()) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                Integer money = null;
                if (field.getType().equals(Integer.class)) {
                    money = (Integer) field.get(account);
                    if (money == null) {
                        throw new IllegalArgumentException("金额不能为空");
                    }
                }
                HasMoney annotation = field.getAnnotation(HasMoney.class);
                if (annotation != null) {
                    if (money < annotation.min() || money > annotation.max()) {
                        throw new IllegalArgumentException("金额不正确");
                    }
                }
            }
        }
        ArrayList<Account> accounts = new ArrayList<>(10);
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Account account1 = new Account();
            for (Method method : accountClass.getMethods()) {
                if (method.getName().startsWith("set")) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes[0].equals(Integer.class)) {
                        method.invoke(account1, method.getName().equals("setId") ? i : random.nextInt(50000));
                    } else {
                        method.invoke(account1, method.getName().equals("setUsername") ? "" + (char) (0x4e00 + random.nextInt(100)) + (char) (0x4e00 + random.nextInt(100)) : String.valueOf(random.nextInt(9999999)));
                    }
                }
            }
            accounts.add(account1);
        }
        Collections.sort(accounts, new Comparator<Account>() {
            @Override
            public int compare(Account o1, Account o2) {
                return o1.getMoney() - o2.getMoney();
            }
        });
        for (Account account1 : accounts) {
            System.out.println(account1.getUsername() + "_" + account1.getPassword() + "money:" + account1.getMoney());
        }
    }
}

class Account {
    private Integer id;
    private String username;
    private String password;
    private String sex;
    private Integer age;
    @NotNull
    @HasMoney(min = 0, max = 500000)
    private Integer money;

    public Account() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}