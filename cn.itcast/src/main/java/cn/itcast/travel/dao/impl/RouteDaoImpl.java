package cn.itcast.travel.dao.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.RouteImgDao;
import cn.itcast.travel.dao.SellerDao;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.RouteImg;
import cn.itcast.travel.domain.Seller;
import cn.itcast.travel.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class RouteDaoImpl implements RouteDao {
    private final JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    private final RouteImgDao ROUTEIMG = new RouteImgDaoImpl();
    private final SellerDao SELLER = new SellerDaoImpl();
    @Override
    public int findTotalCount(int cid,String rname) {
        String sql = "select count(1) from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        if(cid!=0){
            sb.append(" and cid = ?");
            params.add(cid);
        }
        if(!"".equals(rname) && rname!=null  && !"null".equals(rname)){
            sb.append(" and rname like ?");
            params.add("%"+rname+"%");
        }
        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Route> findByPage(int cid, int start,String rname) {
        String sql = "select * from tab_route where 1 = 1";
        StringBuilder sb = new StringBuilder(sql);
        List<Object> params = new ArrayList<>();
        if(cid!=0){
            sb.append(" and cid = ?");
            params.add(cid);
        }
        if(!"".equals(rname) && rname!=null && !"null".equals(rname)){
            sb.append(" and rname like ?");
            params.add("%"+rname+"%");
        }
        sb.append(" limit ?,?");
        params.add(start);
        params.add(10);
        return template.query(sb.toString(),new BeanPropertyRowMapper<Route>(Route.class),params.toArray());
    }

    @Override
    public Route findById(int rid) {
        String sql = "select * from tab_route where rid = ?";
        Route route = template.queryForObject(sql, new BeanPropertyRowMapper<Route>(Route.class), rid);
        List<RouteImg> images = ROUTEIMG.findById(route.getRid());
        Seller seller = SELLER.findById(route.getSid());
        route.setRouteImgList(images);
        route.setSeller(seller);
        return route;
    }
}
