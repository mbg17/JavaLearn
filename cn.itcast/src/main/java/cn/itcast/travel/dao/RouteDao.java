package cn.itcast.travel.dao;

import cn.itcast.travel.domain.Route;

import java.util.List;

public interface RouteDao {
    public int findTotalCount(int cid,String rname);

    public List<Route> findByPage(int cid, int start,String rname);

    public Route findById(int rid);
}
