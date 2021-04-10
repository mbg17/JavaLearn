package com.test.database.translate.scoket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class SocketTest {
    public static void main(String[] args) throws IOException {
        try (   // 打开套接字
                Socket socket = new Socket();
        ) {
            socket.connect(new InetSocketAddress("time-a.nist.gov", 13), 1000);
            // 指定编码读取流对象
            Scanner scanner = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}
