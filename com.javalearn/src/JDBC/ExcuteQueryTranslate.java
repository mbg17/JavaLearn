package JDBC;

import Utils.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class ExcuteQueryTranslate {
    public static void main(String[] args) {
        ArrayList<Empolymee> empolymees = returnEmpolymee2();
//        System.out.println(empolymees);
        for (Empolymee empolymee : empolymees) {
            System.out.println(empolymee);
        }
    }

    public static ArrayList<Empolymee> returnEmpolymee() {
        ArrayList<Empolymee> empList = new ArrayList<>();
        var sql = "select * from emp";
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql:///tongji", "root", "root");
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
        ) {
            Class.forName("com.mysql.jdbc.Driver");
            Empolymee e = null;
            while (resultSet.next()) {
                e = new Empolymee(
                        resultSet.getInt(1),
                        resultSet.getNString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getDate(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getInt(8));
                empList.add(e);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }
    
    public static ArrayList<Empolymee> returnEmpolymee2(){
        ArrayList<Empolymee> empList = new ArrayList<>();
        var sql = "select * from emp";
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            Empolymee e = null;
            while (resultSet.next()) {
                e = new Empolymee(
                        resultSet.getInt(1),
                        resultSet.getNString(2),
                        resultSet.getInt(3),
                        resultSet.getInt(4),
                        resultSet.getDate(5),
                        resultSet.getDouble(6),
                        resultSet.getDouble(7),
                        resultSet.getInt(8));
                empList.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(resultSet,statement,connection);
        }
        return empList;
    }
}

