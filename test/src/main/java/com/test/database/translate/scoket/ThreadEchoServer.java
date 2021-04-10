package com.test.database.translate.scoket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ThreadEchoServer {
    public static void main(String[] args) throws IOException {
        try (var s = new ServerSocket(8189);) {
            // 计数器
            int i = 1;
            // 循环接受请求
            while (true) {
                Socket accept = s.accept();
                System.out.println("num" + i);
                // 开启新线程处理请求
                Runnable threadedEchoHandler = new ThreadedEchoHandler(accept);
                Thread thread = new Thread(threadedEchoHandler);
                thread.start();
                i++;
            }
        }
    }
}

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try (// 获取客户端输入的内容
             InputStream inputStream = incoming.getInputStream();
             // 获取服务器输出流
             OutputStream outputStream = incoming.getOutputStream();) {
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                var out = new PrintWriter(
                        new OutputStreamWriter(outputStream, StandardCharsets.UTF_8),
                        true
                        /* 自动flush */);
                // 响应给客户端
                out.println("hello! Enter Bye to Exit!");
                boolean flag = false;
                // 等待用户输入
                while (!flag && scanner.hasNextLine()) {
                    String s = scanner.nextLine();
                    out.println("Your message" + s);
                    if (s.trim().equals("Bye")) {
                        flag = !flag;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}