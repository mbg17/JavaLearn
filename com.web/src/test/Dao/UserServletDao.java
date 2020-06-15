package test.Dao;

import test.Domain.User;

import java.util.List;

public interface UserServletDao {
    public List<User> findAll();
}
