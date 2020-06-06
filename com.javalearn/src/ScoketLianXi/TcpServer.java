package ScoketLianXi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
    public static void main(String[] args) throws IOException {
        // 创建绑定端口的sever对象
        ServerSocket serverSocket = new ServerSocket(8888);
        // 获取客户端socket对象
        Socket accept = serverSocket.accept();
        // 获取socket输入流
        InputStream inputStream = accept.getInputStream();
        // 接受服务器发送的数据
        byte[] bytes = new byte[1024];
        int len =inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        // 获取socket对象输出流
        OutputStream outputStream = accept.getOutputStream();
        // 向服务器写入数据
        outputStream.write("收到谢谢".getBytes());
        accept.close();
        serverSocket.close();
    }
}
