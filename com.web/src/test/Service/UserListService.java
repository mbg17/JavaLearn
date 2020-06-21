package test.Service;

import Servlet.User;
import test.Domain.PageBean;
import test.Domain.Student;

import java.util.List;
import java.util.Map;

public interface UserListService {
    public List<Student> findAll();

    public User login(User user);

    void addStudent(Student student);

    void delUser(String id);

    Student findUser(String id);

    void update(Student student);

    void delSelected(String[] uids);

    PageBean<Student> findByPageNumber(String currentPage, Map<String, String[]> parameterMap);
}
