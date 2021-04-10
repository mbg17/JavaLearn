package com.test.database.translate.scoket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        // 开启服务器
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            // 等待连接
            try (Socket accept = serverSocket.accept()) {
                // 获取客户端输入的内容
                InputStream inputStream = accept.getInputStream();
                // 获取服务器输出流
                OutputStream outputStream = accept.getOutputStream();
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
            }
        }
    }
}
