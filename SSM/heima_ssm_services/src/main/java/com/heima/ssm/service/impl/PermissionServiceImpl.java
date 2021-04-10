package com.heima.ssm.service.impl;

import com.heima.ssm.dao.PermissionDao;
import com.heima.ssm.domain.Permission;
import com.heima.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }

    @Override
    public void delPermission(String id) throws Exception {
        permissionDao.delRolePermission(id);
        permissionDao.delPermission(id);
    }
}
