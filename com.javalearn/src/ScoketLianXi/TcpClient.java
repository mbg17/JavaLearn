package ScoketLianXi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        // 创建socket对象
        Socket socket = new Socket("127.0.0.1", 8888);
        // 获取socket对象输出流
        OutputStream outputStream = socket.getOutputStream();
        // 向服务器写入数据
        outputStream.write("你好呀".getBytes());
        // 获取socket输入流
        InputStream inputStream = socket.getInputStream();
        // 接受服务器发送的数据
        byte[] bytes = new byte[1024];
        int len =0;
        while((len = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
        socket.close();
    }
}
