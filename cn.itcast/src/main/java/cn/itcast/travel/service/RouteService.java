package cn.itcast.travel.service;

import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;

public interface RouteService {
    public PageBean<Route> fingByPage(int cid,int currentPage,String rname);

    Route fingById(int id);
}
