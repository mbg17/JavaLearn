package com.test.database.lemon.socket;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketClient {
    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket("localhost", 9001);) {
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            System.out.println("服务端连接成功");
            Scanner scanner = new Scanner(System.in);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8));
            System.out.println("服务端发来信息" + bufferedReader.readLine());
            boolean flag = false;
            while (!flag) {
                String next = scanner.next();
                if (next.equals("bye")) {
                    flag = !flag;
                }
                bufferedWriter.write(next);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        }
    }
}
