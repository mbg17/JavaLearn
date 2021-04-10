package com.springcloud.seata.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StorageDao {

    //扣减库存
    @Update("UPDATE t_storage SET used = used + #{count},residue = residue - #{count} WHERE  product_id = #{productId}")
    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}
