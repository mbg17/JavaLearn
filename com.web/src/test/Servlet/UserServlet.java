package test.Servlet;

import InterfaceLianXI.InterfaceA;
import test.Domain.PageBean;
import test.Domain.Student;
import test.Service.Impl.UserListServiceImpl;
import test.Service.UserListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String currentPage = request.getParameter("currentPage");
        if(currentPage==null){
            currentPage="1";
        }
        UserListService us = new UserListServiceImpl();
//        List<Student> students = us.findAll();
//        request.setAttribute("students",students);
        PageBean<Student> pb = us.findByPageNumber(currentPage,parameterMap);
        request.setAttribute("PageBean",pb);
        request.setAttribute("parameterMap",parameterMap);
        request.getRequestDispatcher("/list.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
