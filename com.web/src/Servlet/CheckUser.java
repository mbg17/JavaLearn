package Servlet;

import JDBCTools.JdbcTool;
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

class User{
    private String username;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password=" + password +
                '}';
    }
}
