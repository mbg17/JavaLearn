package com.heima.ssm.dao;

import com.heima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {

    @Select("select * from PERMISSION where id in (select permissionid from ROLE_PERMISSION where roleid=#{roleid})")
    List<Permission> findByRoleId(String roleid) throws Exception;

    @Select("select * from PERMISSION")
    List<Permission> findAll() throws Exception;

    @Insert("insert into PERMISSION(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Delete("delete from ROLE_PERMISSION where permissionid = #{id}")
    void delRolePermission(String id) throws Exception;

    @Delete("delete from PERMISSION where id = #{id}")
    void delPermission(String id) throws Exception;
}
