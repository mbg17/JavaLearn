package test.Servlet;

import test.Domain.Student;
import test.Service.Impl.UserListServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        UserListServiceImpl userListService = new UserListServiceImpl();
        Student st = userListService.findUser(id);
        if(st!=null){
            request.setAttribute("student",st);
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }else {
            response.sendRedirect("/userServlet");
        }
    }
}
