package com.heima.ssm.service.impl;

import com.heima.ssm.dao.UserDao;
import com.heima.ssm.domain.Role;
import com.heima.ssm.domain.UserInfo;
import com.heima.ssm.service.UserService;
import com.heima.ssm.utils.BcryptPasswordEncoderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo byUserName = null;
        try {
            byUserName = userDao.findByUserName(username);
            System.out.println(byUserName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        User user = new User(byUserName.getUsername(), byUserName.getPassword(),byUserName.getStatus()==0?false:true,true,true,true,getAuthority(byUserName.getRoles()));
        return user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName().toUpperCase()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    @Override
    public void saveUser(UserInfo userInfo) throws Exception {
        userInfo.setPassword(BcryptPasswordEncoderUtils.returnBCryptPasswordEncoder(userInfo.getPassword()));
        userDao.saveUser(userInfo);
    }

    @Override
    public UserInfo findById(String id) throws Exception {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findOtherRoles(String userid) throws Exception{
        return userDao.findOtherRoles(userid);
    }

    @Override
    public void saveRoles(String userid, String[] ids) throws Exception {
        for (String roleid : ids) {
            userDao.saveRoles(userid,roleid);
        }
    }
}
