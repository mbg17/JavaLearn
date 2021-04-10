package com.heima.ssm.dao;

import com.heima.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TravellerDao {

    @Select("select * from traveller where id in (select travellerid from ORDER_TRAVELLER where orderid = #{orderid})")
    List<Traveller> findAll(String orderid) throws Exception;
}
