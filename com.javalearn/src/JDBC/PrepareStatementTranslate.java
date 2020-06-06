package JDBC;

import Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementTranslate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.next();
        System.out.println("请输入密码");
        Integer password = scanner.nextInt();
        String sql = "select * from user where username = ? and password = ?";
        Connection connection = null;
        PreparedStatement preparedStatement  = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setInt(2,password);
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("登陆成功");
            }else{
                System.out.println("登录失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,preparedStatement,connection);
        }

    }
}
