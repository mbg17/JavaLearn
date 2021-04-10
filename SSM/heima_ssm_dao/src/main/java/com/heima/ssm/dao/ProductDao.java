package com.heima.ssm.dao;

import com.heima.ssm.domain.Product;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductDao {

    @Select("select * from product")
    List<Product> findAll() throws Exception;

    @Select("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product) throws Exception;

    @Select("select * from product where id=#{id}")
    Product findById(String id) throws Exception;

    @Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus} where id = #{id}")
    void updateProduct(Product product) throws Exception;
}
