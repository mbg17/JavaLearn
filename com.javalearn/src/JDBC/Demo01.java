package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        // 导入jar包
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接对象
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tongji","root","root");
        // 定义sql
        String sql = "select * from emp";
        // 获取执行语句对象
        Statement statement = connection.createStatement();
        // 执行语句
        boolean execute = statement.execute(sql);
        // 处理结果
        System.out.println(execute);
        // 释放资源
        statement.close();
        connection.close();
    }
}
