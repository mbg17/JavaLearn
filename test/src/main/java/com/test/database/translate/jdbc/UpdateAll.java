package com.test.database.translate.jdbc;

import java.sql.*;

public class UpdateAll {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 设置用户名密码
        String url = "jdbc:mysql://localhost:3306/ssm";
        String username = "root";
        String password = "root";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);) {
            // 批量更新或插入
            for (int i = 0; i < 10; i++) {
                String sql = "insert into account (id,name,money) values (null,'luyuan"+i+"'," + i * 100 + ")";
                statement.addBatch(sql);
            }
            int[] ints = statement.executeBatch();
        }
    }
}
