package test.Service.Impl;

import Servlet.User;
import test.Dao.Impl.UserServletDaoImpl;
import test.Dao.UserServletDao;
import test.Domain.PageBean;
import test.Domain.Student;
import test.Service.UserListService;

import java.util.List;
import java.util.Map;

public class UserListServiceImpl implements UserListService {
    private UserServletDao dao = new UserServletDaoImpl();
    @Override
    public List<Student> findAll() {
        UserServletDao dao = new UserServletDaoImpl();
        List<Student> all = dao.findAll();
        return all;
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void addStudent(Student student) {
        dao.add(student);
    }

    @Override
    public void delUser(String id) {
        dao.del(id);
    }

    @Override
    public Student findUser(String id) {
        Student st = dao.findUser(id);
        return st;
    }

    @Override
    public void update(Student student) {
        dao.update(student);
    }

    @Override
    public void delSelected(String[] uids) {
        dao.delSelected(uids);
    }

    @Override
    public PageBean<Student> findByPageNumber(String currentPage, Map<String, String[]> parameterMap) {
        PageBean<Student> pb = new PageBean<>();
        try {
            pb = dao.findStudentByPage(currentPage,parameterMap);
        }catch (Exception e){

        }
        return pb;
    }
}
