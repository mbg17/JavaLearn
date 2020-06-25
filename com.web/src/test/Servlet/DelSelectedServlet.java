package test.Servlet;

import test.Service.Impl.UserListServiceImpl;
import test.Service.UserListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            String[] uids = request.getParameterValues("uid");
            UserListService userListService = new UserListServiceImpl();
            userListService.delSelected(uids);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            response.sendRedirect("/userServlet");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
