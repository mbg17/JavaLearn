package com.heima.ssm.dao;

import com.heima.ssm.domain.Role;
import com.heima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "username" ,column = "username"),
            @Result(property = "password" ,column = "password"),
            @Result(property = "phoneNum" ,column = "phoneNum"),
            @Result(property = "status" ,column = "status"),
            @Result(property = "roles" ,column = "id",many = @Many(select = "com.heima.ssm.dao.RoleDao.findRolesByUserId",fetchType = FetchType.LAZY))
    })
    UserInfo findByUserName(String username) throws Exception;

    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    @Insert("insert into users (email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void saveUser(UserInfo userInfo) throws Exception;

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "username" ,column = "username"),
            @Result(property = "password" ,column = "password"),
            @Result(property = "phoneNum" ,column = "phoneNum"),
            @Result(property = "status" ,column = "status"),
            @Result(property = "roles" ,column = "id",many = @Many(select = "com.heima.ssm.dao.RoleDao.findRolesByUserId",fetchType = FetchType.LAZY))
    })
    UserInfo findById(String id) throws Exception;

    @Select("select * from role where id not in (select roleid from users_role where userid =#{userid})")
    List<Role> findOtherRoles(String userid) throws Exception;


    @Insert("insert into users_role (userid,roleid) values(#{userId},#{roleId})")
    void saveRoles(@Param("userId") String userid, @Param("roleId")String roleid) throws Exception;
}
