package com.springcloud.payment.Dao;

import com.springcloud.payment.domain.Payment;
import org.apache.ibatis.annotations.*;

@Mapper
public interface PaymentDao {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into account(name,money) values (#{name},#{money})")
    Integer save(Payment payment);

    @Select("select * from account where id = #{id}")
    Payment findById(@Param("id") Integer id);
}
