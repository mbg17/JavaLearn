package JDBC;

import Utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionDemo {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement  = null;
        String sql = "update user set password = ? where username = ? ";
        try {
            connection = JDBCUtil.getConnection();
            connection.setAutoCommit(false);// 开启事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,888888);
            preparedStatement.setString(2,"luyuan");
            preparedStatement.executeUpdate();
            connection.commit();// 提交事务
        } catch (Exception e) {
            try {
                if(connection!=null){
                    connection.rollback();// 报错回滚事务
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
