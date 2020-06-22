package Login;

import Servlet.CheckUser;
import Servlet.User;
import org.apache.commons.beanutils.BeanUtils;

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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String code = request.getParameter("code");
        Map<String, String> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        User user = new User();
        try {
            if(code!=null && "aaaa".equalsIgnoreCase(code)){
                BeanUtils.populate(user,map);
                User user1 = CheckUser.checkUser(user);
                if(user1!=null){
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user1);
                    System.out.println(session.getAttribute("user"));
                    RequestDispatcher requestDispatcher = request.getRequestDispatcher("/success.jsp");
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
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
