package test.Dao.Impl;

import JDBCTools.JdbcTool;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.Dao.UserServletDao;
import test.Domain.User;

import java.util.List;

public class UserServletDaoImpl implements UserServletDao {
    private JdbcTemplate jdbc = new JdbcTemplate(JdbcTool.getFactory());
    @Override
    public List<User> findAll() {
        String sql = "select * from student";
        List<User> query = jdbc.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return query;
    }
}
