package com.heima.ssm.service;

import com.heima.ssm.dao.UserDao;
import com.heima.ssm.domain.Role;
import com.heima.ssm.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll() throws Exception;

    void saveUser(UserInfo userInfo) throws Exception;

    UserInfo findById(String id) throws Exception;

    List<Role> findOtherRoles(String userid) throws Exception;

    void saveRoles(String userid, String[] ids) throws Exception;
}
