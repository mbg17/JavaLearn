package test.Servlet;

import Servlet.CheckUser;
import Servlet.User;
import org.apache.commons.beanutils.BeanUtils;
import test.Service.Impl.UserListServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = request.getParameterMap();
        String code = request.getParameter("verifycode");
        System.out.println(code);
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        request.getSession().removeAttribute("CHECKCODE_SERVER");
        User user = new User();
        try {
            if(code!=null && code.equalsIgnoreCase(checkcode_server)){
                BeanUtils.populate(user,parameterMap);
                User user1 = new UserListServiceImpl().login(user);
                if(user1!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user1);
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
                    requestDispatcher.forward(request,response);
                }else{
                    request.setAttribute("errorMsg","用户名或密码错误");
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
                    requestDispatcher.forward(request,response);
                }
            }else{
                request.setAttribute("errorMsg","验证码错误");
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
                requestDispatcher.forward(request,response);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
