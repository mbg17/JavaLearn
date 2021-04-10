package com.test.database.translate.jdbc;

import java.sql.*;
import java.util.Scanner;

public class Books {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 设置用户名密码
        String url = "jdbc:mysql://localhost:3306/bugs";
        String username = "root";
        String password = "root";
        // 建立连接 执行sql
        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ) {
            int id = 0;
            PreparedStatement preparedStatement = null;
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入你要的操作，按q退出,输入help 显示帮助");
            boolean quit = false;
            while (!quit) {
                String next = scanner.next();
                switch (next) {
                    case "help":
                        System.out.println("add:添加");
                        System.out.println("update:更新");
                        System.out.println("delete:删除");
                        System.out.println("list:查询");
                        break;
                    case "q":
                        quit = !quit;
                        break;
                    case "list":
                        ResultSet resultSet = statement.executeQuery("select * from books");
                        while (resultSet.next()) {
                            System.out.println("id:" + resultSet.getInt(1) + ",书名:"
                                    + resultSet.getString(2) + ",价格："
                                    + resultSet.getInt(3));
                            resultSet.updateInt(3, resultSet.getInt(3) + 200);
                            resultSet.updateRow();
                        }
                        break;
                    case "add":
                        boolean isAdd = false;
                        preparedStatement = connection.prepareStatement("insert into books(name,price) values (?,?)");
                        while (!isAdd) {
                            System.out.println("请输入书名");
                            String bookName = scanner.next();
                            System.out.println("请输入价格");
                            int price = scanner.nextInt();
                            preparedStatement.setString(1, bookName);
                            preparedStatement.setInt(2, price);
                            preparedStatement.addBatch();
                            System.out.println("是否继续添加，按q退出,按n继续");
                            String add = scanner.next();
                            if ("q".equals(add)) {
                                isAdd = !isAdd;
                                preparedStatement.executeBatch();
                            }
                        }
                        break;
                    case "delete":
                        String sql = new String("delete from books where id = ?");
                        System.out.println("请输入编号");
                        id = scanner.nextInt();
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.setInt(1, id);
                        preparedStatement.execute();
                        System.out.println("删除成功");
                        break;
                    case "update":
                        System.out.println("请输入编号");
                        id = scanner.nextInt();
                        System.out.println("请输入书名");
                        String bookName = scanner.next();
                        ResultSet ans = statement.executeQuery("select * from books where id = " + id);
                        if (!ans.next()) {
                            System.out.println("没有该数据无法更新");
                            break;
                        }
                        preparedStatement = connection.prepareStatement("update books set name='" + bookName + "' where id = " + id);
                        int i = preparedStatement.executeUpdate();
                        System.out.println("更新" + i + "条数据");
                        break;
                    default:
                        System.out.println("指令错误");
                }
            }
        }
    }
}
