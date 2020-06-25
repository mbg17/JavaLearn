package test.Web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.http.HttpRequest;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String requestURI = request.getRequestURI();
        if(requestURI.contains("/checkCode")||"/login.jsp".equals(requestURI) || "/loginServlet".equals(requestURI)|| requestURI.contains("/css")|| requestURI.contains("/js")){
            chain.doFilter(req, resp);
        }else{
            if(request.getSession().getAttribute("user")!=null){
                chain.doFilter(req, resp);
            }else{
                request.setAttribute("errorMsg","用户未登录！");
                request.getRequestDispatcher("/login.jsp").forward(request,resp);
            }
        }
    }

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

}
