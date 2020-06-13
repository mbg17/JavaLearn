package Servlet;

import JDBCTools.JdbcTool;
import org.springframework.beans.BeanUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
@SuppressWarnings("all")
public class CheckUser {
    private static JdbcTemplate jb = new JdbcTemplate(JdbcTool.getFactory());

    public static User checkUser(User u){
        var sql = "select * from user where username= ? and password = ?";
        try {
            User user = jb.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    u.getUsername(), u.getPassword());
            return user;
        }catch (Exception e){
            System.out.println(e);
            return  null;
        }

    }
}

