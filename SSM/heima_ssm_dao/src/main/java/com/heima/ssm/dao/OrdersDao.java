package com.heima.ssm.dao;

import com.heima.ssm.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrdersDao {
    @Select("select * from orders where id = #{id}")
    @Results(id="userAccounts",value = {
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "product",column = "productid",one = @One(
                    select = "com.heima.ssm.dao.ProductDao.findById",fetchType = FetchType.EAGER
            )),
            @Result(property = "member",column = "memberid",one = @One(
                    select = "com.heima.ssm.dao.MemberDao.findById",fetchType = FetchType.EAGER
            )),
            @Result(property = "travellers",column = "id",many = @Many(
                    select = "com.heima.ssm.dao.TravellerDao.findAll",fetchType = FetchType.LAZY
            ))
    })
    Orders findById(String id) throws Exception;


    @Select("select * from orders")
    @Results(id="allOrders",value = {
            @Result(id=true,property = "id" ,column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "product",column = "productid",one = @One(
                    select = "com.heima.ssm.dao.ProductDao.findById",fetchType = FetchType.LAZY
            ))}
    )
    List<Orders> findAll() throws Exception;

}
