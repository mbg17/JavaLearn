package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.RouteDao;
import cn.itcast.travel.dao.impl.RouteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.service.RouteService;

public class RouteServiceImpl implements RouteService {
    private final RouteDao dao = new RouteDaoImpl();
    @Override
    public PageBean<Route> fingByPage(int cid, int currentPage,String rname) {
        PageBean<Route> bean = new PageBean<>();
        int totalCount= dao.findTotalCount(cid,rname);
        int totalPages = (int) Math.ceil((double) totalCount/(double) bean.getRows());
//        currentPage = currentPage>=totalPages?totalPages:currentPage;
        if(currentPage>totalPages){
            currentPage=totalPages-1<0?1:totalPages;
        }else if(currentPage<=0){
            currentPage=1;
        }
        bean.setTotalCount(dao.findTotalCount(cid,rname));
        bean.setCurrentPage(currentPage);
        bean.setTotalPages(totalPages);
        bean.setList(dao.findByPage(cid,(bean.getCurrentPage()-1)*bean.getRows(),rname));
        return bean;
    }

    @Override
    public Route fingById(int id) {
        Route route = dao.findById(id);
        return route;
    }
}
