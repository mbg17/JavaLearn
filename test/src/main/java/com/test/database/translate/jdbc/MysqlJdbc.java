package com.test.database.translate.jdbc;

import java.sql.*;

public class MysqlJdbc {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 设置用户名密码
        String url = "jdbc:mysql://localhost:3306/ssm";
        String username = "root";
        String password = "root";
        // 建立连接 执行sql
        try (Connection connection = DriverManager.getConnection(url, username, password);
<<<<<<< HEAD
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            ResultSet resultSet = statement.executeQuery("select * from account");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + ":"
                        + resultSet.getString(2) + ":"
                        + resultSet.getInt(3));
                resultSet.updateInt(3, resultSet.getInt(3) + 200);
                resultSet.updateRow();
            }
=======
             Statement statement = connection.createStatement();) {
            ResultSet resultSet = statement.executeQuery("select * from account");
           while (resultSet.next()){
               System.out.println(resultSet.getInt(1)+":"
                       +resultSet.getString(2)+":"
                       +resultSet.getInt(3));
           }
>>>>>>> origin/master
        }
    }
}
