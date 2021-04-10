package com.heima.ssm.service;

import com.heima.ssm.domain.Permission;
import com.heima.ssm.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    void delRole(String id) throws Exception;

    List<Permission> findOtherPermission(String id) throws Exception;

    void savePermission(String roleid, String[] ids) throws Exception;
}
