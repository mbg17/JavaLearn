package test.Dao;

import Servlet.User;
import test.Domain.PageBean;
import test.Domain.Student;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface UserServletDao {
    public List<Student> findAll();

    public User findUserByUsernameAndPassword(String name,String password);

    void add(Student student);

    void del(String id);

    Student findUser(String id);

    void update(Student student);

    void delSelected(String[] uids);

    int findTotalCount(Map<String, String[]> parameterMap);

    PageBean<Student> findStudentByPage(String currentPage, Map<String, String[]> parameterMap);
}
