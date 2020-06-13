package Download;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInput;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/CookieTest")
public class CookieTest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        String time = null;
        boolean flag = false;
        if(cookies!=null && cookies.length>0){
            for (Cookie cookie : cookies) {
                String name = cookie.getName();
                if("lastTime".equals(name)){
                    flag = true;
                    // 解码并赋值
                    time= URLDecoder.decode(cookie.getValue(),"utf-8");
                    break;
                }
            }
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = simpleDateFormat.format(date);
        // 编码赋值
        format = URLEncoder.encode(format,"utf-8");
        Cookie cookie = new Cookie("lastTime",format);
        // 设置超时时间
        cookie.setMaxAge(60 * 60 *24 * 30);
        response.addCookie(cookie);
        if(flag==false && time ==null){
            response.getWriter().write("欢迎首次访问");
        }else{
            response.getWriter().write("上次访问时间为"+time);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
