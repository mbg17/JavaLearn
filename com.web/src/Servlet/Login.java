package Servlet;

import JDBCTools.JdbcTool;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User loginUser = new User(username,password);
        User user1 = CheckUser.checkUser(loginUser);
        if(user1!=null){
            request.setAttribute("user",user1);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success");
            requestDispatcher.forward(request,response);
        }else{
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/fail");
            requestDispatcher.forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
