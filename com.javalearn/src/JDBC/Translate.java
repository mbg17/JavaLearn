package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Translate {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection("jdbc:mysql:///tongji?characterEncoding=utf8", "root", "root");
                Statement statement = connection.createStatement();
                ){
            Class.forName("com.mysql.jdbc.Driver");

            var insert = "insert into employee (name,dep_id) values ('嘻嘻',1)";
            var update = "update employee set dep_id = 2 where id =2";
            var delete = "delete from employee where id = 1";
            int i = statement.executeUpdate(insert);
            int x = statement.executeUpdate(update);
            int y = statement.executeUpdate(delete);
            System.out.println(i+""+x+""+y);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
