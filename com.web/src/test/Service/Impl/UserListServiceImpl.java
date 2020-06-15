package test.Service.Impl;

import test.Dao.Impl.UserServletDaoImpl;
import test.Dao.UserServletDao;
import test.Domain.User;
import test.Service.UserListService;

import java.util.List;

public class UserListServiceImpl implements UserListService {
    @Override
    public List<User> findAll() {
        UserServletDao dao = new UserServletDaoImpl();
        List<User> all = dao.findAll();
        return all;
    }
}
