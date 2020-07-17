package cn.itcast.travel.web.servlet;

import cn.itcast.travel.dao.FavouriteDao;
import cn.itcast.travel.dao.impl.FavouriteDaoImpl;
import cn.itcast.travel.domain.PageBean;
import cn.itcast.travel.domain.Route;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.FavouriteService;
import cn.itcast.travel.service.RouteService;
import cn.itcast.travel.service.impl.FavouriteServiceImpl;
import cn.itcast.travel.service.impl.RouteServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/route/*")
public class RouteServlet extends BaseServlet {
    public void findByPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String cid = request.getParameter("cid");
        String rname = request.getParameter("rname");
        if(rname!=null && rname.length()>0 && !"".equals(rname)){
            rname = new String(rname.getBytes("iso-8859-1"), "utf-8");
        }
        int page =0;
        int id=0;
        if(currentPage!=null && currentPage.length()>0){
            try{
                page = Integer.parseInt(currentPage);
            }catch (NumberFormatException e){
                page=1;
            }
        }else{
            page=1;
        }
        if(cid!=null && cid.length()>0 && !"null".equals(cid)){
            try{
                id = Integer.parseInt(cid);
            }catch (NumberFormatException e){
                id=1;
            }
        }
        RouteService routeService = new RouteServiceImpl();
        PageBean<Route> routePageBean = routeService.fingByPage(id, page,rname);
        String s = writeValueAsString(routePageBean);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void findById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rid = request.getParameter("rid");
        int id=0;
        if(rid!=null && rid.length()>0){
            try{
                id = Integer.parseInt(rid);
            }catch (NumberFormatException e){
                id=1;
            }
        }
        RouteService routeService = new RouteServiceImpl();
        Route route = routeService.fingById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String s = objectMapper.writeValueAsString(route);
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(s);
    }

    public void isFavourute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        Map<String,Object> map = new HashMap<>();
        FavouriteService favouriteService = new FavouriteServiceImpl();
        int uid;
        if(user==null){
            uid=0;
            map.put("flag",false);
        }else{
            uid=user.getUid();
            boolean byUidAndRid = favouriteService.findByUidAndRid(Integer.parseInt(rid),uid );
            map.put("flag",byUidAndRid);
        }
        int i = favouriteService.favouriteCount(Integer.parseInt(rid));
        map.put("count",i);
        response.setContentType("application/json;charset=utf-8");
        writeValue(response.getOutputStream(),map);
    }

    public void addFavourite(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String rid = request.getParameter("rid");
        User user = (User) request.getSession().getAttribute("user");
        int uid;
        Map<String,Object> map = new HashMap<>();
        FavouriteDao favouriteDao = new FavouriteDaoImpl();
        if(user==null){
            map.put("flag",false);
            map.put("msg","请登录后点赞");
        }else{
            uid=user.getUid();
            boolean b = favouriteDao.addFavourite(Integer.parseInt(rid),uid);
            if(b==true){
                map.put("flag",true);
                map.put("msg","点赞成功");
            }else{
                map.put("flag",false);
                map.put("msg","点赞失败");
            }
        }
        response.setContentType("application/json;charset=utf-8");
        writeValue(response.getOutputStream(),map);
    }
}
