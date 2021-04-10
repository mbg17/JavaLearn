package com.test.database.lemon.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket socketServer = new ServerSocket(9001);) {
            System.out.println("服务端已启动");
            while (true) {
                Socket accept = socketServer.accept();
                System.out.println("" + accept.getInetAddress() + ":" + accept.getPort() + "已接入");
                SocketHander socketHander = new SocketHander(accept);
                socketHander.start();
            }
        }
    }
}

class SocketHander extends Thread {
    private Socket socket;

    public SocketHander(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            // 获取服务器输入输出流
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            bufferedWriter.write("已建立链接，回复bye退出");
            bufferedWriter.newLine();
            bufferedWriter.flush();
            while (true) {
                String message = bufferedReader.readLine();
                System.out.println(String.format("【收到消息(客户端地址：%s，线程名：%s)】%s", socket.getRemoteSocketAddress(), Thread.currentThread().getName(), message));
                if (message.equals("bye")) {
                    System.out.println("客户端链接断开");
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("服务器已断开");
        } finally {
            try {
                this.socket.close();
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
