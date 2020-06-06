package ScoketLianXi.UploadLianXi;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        // 优化上传名称
        // 优化上传速度（开启多线程）
        // 不停止服务端
        File file = new File("D:\\JAVA\\com.javalearn\\src\\ScoketLianXi\\UploadLianXi\\upload");
        if(!file.exists()){
            file.mkdirs();
        }
        while(true){
            Socket accept = serverSocket.accept();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try(InputStream inputStream = accept.getInputStream();
                        OutputStream outputStream = accept.getOutputStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(file+"\\"+System.currentTimeMillis()+".txt");){
                        byte[] bytes=new byte[1024];
                        int len;
                        while((len = inputStream.read(bytes))!=-1){
                            fileOutputStream.write(bytes,0,len);
                        }
                        outputStream.write("上传完毕".getBytes());
                    }catch (IOException e){
                        System.out.println(e);
                    }
                }
            }).start();
        }
        // serverSocket.close();
    }
}
