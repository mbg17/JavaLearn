package ScoketLianXi.UploadLianXi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class BSDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket accept = serverSocket.accept();
            new Thread(() -> {
                    // jdk7特性捕获异常自动释放资源
                    try (InputStream inputStream = accept.getInputStream();
                         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                         OutputStream outputStream = accept.getOutputStream();){
                        String s = bufferedReader.readLine();// 获取请求的第一行
                        String[] s1 = s.split(" ");// 切割字符串
                        String substring = s1[1].substring(1);
                        // 编写响应头
                        outputStream.write("HTTP/1.1 200 OK\r\n".getBytes());
                        outputStream.write("Content-type:text/html\r\n".getBytes());
                        outputStream.write("\r\n".getBytes());
                        // 获取本地字节输入流读写页面
                        FileInputStream fileInputStream = new FileInputStream("com.javalearn\\"+substring);
                        int len;
                        byte[] bytes = new byte[1024];
                        // 将页面响应给浏览器
                        while ((len = fileInputStream.read(bytes))>=1) {
                            outputStream.write(bytes,0,len);
                        }
                        fileInputStream.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }

            }).start();
        }
    }
}
