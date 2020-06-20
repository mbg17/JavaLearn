package test.Service;

import Servlet.User;
import test.Domain.Student;

import java.util.List;

public interface UserListService {
    public List<Student> findAll();

    public User login(User user);

    void addStudent(Student student);

    void delUser(String id);

    Student findUser(String id);

    void update(Student student);

    void delSelected(String[] uids);
}
