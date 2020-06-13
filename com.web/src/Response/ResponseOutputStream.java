package Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ResponseOutputStream")
public class ResponseOutputStream extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码响应格式
//        response.setContentType("text/html;charset=utf-8");
        // 获取字节流输出对象
        ServletOutputStream outputStream = response.getOutputStream();
        // 输出到浏览器
        outputStream.write("你好,response".getBytes("gbk"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
