package ScoketLianXi.UploadLianXi;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8888);
        FileInputStream fileInputStream = new FileInputStream("D:\\JAVA\\com.javalearn\\src\\ScoketLianXi\\UploadLianXi\\UploadTxt.txt");
        OutputStream outputStream = socket.getOutputStream();
        byte[] bytes =new byte[1024];
        int len;
        while((len = fileInputStream.read(bytes))>=1){
            outputStream.write(bytes,0,len);
        }
        // 向服务端发送终止符
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        while((len=inputStream.read(bytes))!=-1){
            System.out.print(new String(bytes,0,len));
        }
//        System.out.print(new String(bytes,0,len=inputStream.read(bytes)));
        fileInputStream.close();
        socket.close();
    }
}
