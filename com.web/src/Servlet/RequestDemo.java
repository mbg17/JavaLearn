package Servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/test")
public class RequestDemo extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取post字符流对象
        BufferedReader reader = request.getReader();
        char[] chars = new char[1024];
        int i = 0;
        while((i=reader.read(chars))!=-1){
            // 打印数据
            System.out.println(new String(chars,0,i));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取所有请求头名称
        Enumeration<String> headers = request.getHeaderNames();
        while(headers.hasMoreElements()){
            // 获取请求头的值
            String s = headers.nextElement();
            System.out.println(s+":"+request.getHeader(s));
        }

        // 获取请求方法
        String method = request.getMethod();
        System.out.println(method);

        // 获取请求参数
        String queryString = request.getQueryString();
        System.out.println(queryString);

        // 获取虚拟目录
        String contextPath = request.getContextPath();
        System.out.println("=="+contextPath);

        // 获取servlet路径
        String servletPath = request.getServletPath();
        System.out.println(servletPath);

        // 获取统一资源标识符&&定位符
        String requestURI = request.getRequestURI();
        StringBuffer requestURL = request.getRequestURL();
        System.out.println(requestURI);
        System.out.println(requestURL);

        // 获取协议版本
        String protocol = request.getProtocol();
        System.out.println(protocol);

        // 获取客户端IP地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
