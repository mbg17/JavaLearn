package com.heima.ssm.service.impl;

import com.heima.ssm.dao.RoleDao;
import com.heima.ssm.domain.Permission;
import com.heima.ssm.domain.Role;
import com.heima.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findByid(id);
    }

    @Override
    public void delRole(String id) throws Exception {
        roleDao.delUserRole(id);
        roleDao.delRolePermission(id);
        roleDao.delRole(id);
    }

    @Override
    public List<Permission> findOtherPermission(String id) throws Exception{
        return roleDao.findOtherPermission(id);
    }

    @Override
    public void savePermission(String roleid, String[] ids) throws Exception {
        for (String permissionId : ids) {
            roleDao.savePermission(roleid,permissionId);
        }
    }
}
