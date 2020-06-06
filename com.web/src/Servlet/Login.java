package Servlet;

import JDBCTools.JdbcTool;
import org.springframework.jdbc.core.JdbcTemplate;

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
        DataSource factory = JdbcTool.getFactory();
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcTool.getFactory());
        Connection connection = null;
        PreparedStatement preparedStatement= null;
        ResultSet resultSet= null;
        var sql = "select * from user where username=? and password = ?";
        try {
            connection = factory.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setInt(2,Integer.parseInt(password));
            resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                System.out.println("ok");
            }else {
                System.out.println("error");
            }
        } catch (SQLException e) {
            JdbcTool.close(resultSet,preparedStatement,connection);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
