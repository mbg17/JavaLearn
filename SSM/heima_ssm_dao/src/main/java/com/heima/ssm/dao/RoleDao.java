package com.heima.ssm.dao;

import com.heima.ssm.domain.Permission;
import com.heima.ssm.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "roleName" ,column = "roleName"),
            @Result(property = "roleDesc" ,column = "roleDesc"),
            @Result(property = "permissions" ,column = "id",many = @Many(select = "com.heima.ssm.dao.PermissionDao.findByRoleId",fetchType = FetchType.LAZY))
    })
    List<Role> findRolesByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "roleName" ,column = "roleName"),
            @Result(property = "roleDesc" ,column = "roleDesc"),
            @Result(property = "permissions" ,column = "id",many = @Many(select = "com.heima.ssm.dao.PermissionDao.findByRoleId",fetchType = FetchType.LAZY))
    })
    Role findByid(String id) throws Exception;

    @Delete("delete from users_role where roleid=#{id}")
    void delUserRole(String id) throws Exception;

    @Delete("delete from ROLE_PERMISSION where roleid=#{id}")
    void delRolePermission(String id) throws Exception;

    @Delete("delete from ROLE where id=#{id}")
    void delRole(String id) throws Exception;

    @Select("select * from permission where id not in (select permissionid from ROLE_PERMISSION where roleid=#{id})")
    List<Permission> findOtherPermission(String id) throws Exception;

    @Insert("insert into ROLE_PERMISSION (roleid,permissionid) values (#{roleId},#{permissionId})")
    void savePermission(@Param("roleId") String roleid,@Param("permissionId") String permissionId) throws Exception;
}
