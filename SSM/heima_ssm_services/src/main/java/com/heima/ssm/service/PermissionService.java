package com.heima.ssm.service;

import com.heima.ssm.domain.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> findAll() throws Exception;

    void save(Permission permission) throws Exception;

    void delPermission(String id) throws Exception;
}
