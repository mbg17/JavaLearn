package test.Dao;

import Servlet.User;
import test.Domain.Student;

import java.util.List;

public interface UserServletDao {
    public List<Student> findAll();

    public User findUserByUsernameAndPassword(String name,String password);

    void add(Student student);

    void del(String id);

    Student findUser(String id);

    void update(Student student);

    void delSelected(String[] uids);
}
