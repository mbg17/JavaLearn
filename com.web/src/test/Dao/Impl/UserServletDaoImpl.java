package test.Dao.Impl;

import JDBCTools.JdbcTool;
import Servlet.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import test.Dao.UserServletDao;
import test.Domain.Student;

import java.util.List;

public class UserServletDaoImpl implements UserServletDao {
    private JdbcTemplate jdbc = new JdbcTemplate(JdbcTool.getFactory());

    @Override
    public List<Student> findAll() {
        String sql = "select * from student";
        List<Student> query = jdbc.query(sql, new BeanPropertyRowMapper<Student>(Student.class));
        return query;
    }

    @Override
    public User findUserByUsernameAndPassword(String name, String password) {
        var sql = "select * from user where username= ? and password = ?";
        try {
            User user = jdbc.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    name, password);
            return user;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }

    }

    @Override
    public void add(Student student) {
        var sql = "insert into student values (null,?,?,?,?,?,?)";
        jdbc.update(sql, student.getName(), student.getAge(), student.getGender(), student.getAddress(), student.getQq(), student.getEmail());
    }

    @Override
    public void del(String id) {
        var sql = "delete from student where id = ?";
        jdbc.update(sql,Integer.parseInt(id));
    }

    @Override
    public Student findUser(String id) {
        var sql = "select * from student where id = ?";
        try {
            Student st = jdbc.queryForObject(sql,
                    new BeanPropertyRowMapper<Student>(Student.class),
                    id);
            return st;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @Override
    public void update(Student student) {
        System.out.println(student);
        var sql = "update student set name=?,age=?,gender=?,address=?,qq=?,email=? where id=?";
        jdbc.update(sql,student.getName(),student.getAge(),student.getGender(),student.getAddress(),student.getQq(),student.getEmail(),student.getId());
    }

    @Override
    public void delSelected(String[] uids) {
        if (uids!=null && uids.length>0){
            for (String uid : uids) {
                this.del(uid);
            }
        }
    }

}
