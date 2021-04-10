package com.springcloud.seata.dao;

import com.springcloud.seata.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderDao {

    @Insert("insert into t_order (id,user_id,product_id,count,money,status) values (null,#{userId},#{productId},#{count},#{money},0)")
    void create(Order order);

    @Update( "update t_order set status = 1 where user_id=#{userId} and status = #{status}")
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
