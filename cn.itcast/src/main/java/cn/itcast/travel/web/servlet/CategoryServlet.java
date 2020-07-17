package cn.itcast.travel.web.servlet;

import cn.itcast.travel.dao.CategoryDao;
import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 陆远
 */
@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private final CategoryService cd = new CategoryServiceImpl();

    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> all = cd.findAll();
        StringBuilder append = new StringBuilder();
        append.append("<li class=\"nav-active\"><a href=\"index.html\">首页</a></li>");
        for (Category category : all) {
            append.append("<li><a href=\"route_list.html?cid="+category.getCid()+"\">" + category.getCname() + "</a></li>");
        }
        append.append("<li><a href=\"favoriterank.html\">收藏排行榜</a></li>");
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(append.toString());
    }

}
