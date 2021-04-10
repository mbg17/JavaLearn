package com.test.database.translate.UrlConnection;

import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UrlConnectionTest {
    public static void main(String[] args) {
        try {
            // url链接
            String urlName = "http://horstman.com";
            // 建立链接
            URL url = new URL(urlName);
            URLConnection urlConnection = url.openConnection();
            // 设置账号密码
            String username = "luyuan";
            String password = "password";
            String input = username + ":" + password;
            // 转换账号密码为base64
            Base64.Encoder encoder = Base64.getEncoder();
            String s = encoder.encodeToString(input.getBytes(StandardCharsets.UTF_8));
            // 设置请求头
            urlConnection.setRequestProperty("Authorization", "Basic " + s);
            // 建立链接
            urlConnection.connect();
            // 获取请求头键值对
            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
            headerFields.entrySet().forEach((k) -> {
                String key = k.getKey();
                for (String s1 : k.getValue()) {
                    System.out.println(key + ":" + s1);
                }
            });
            // 获取请求头相关属性
            System.out.println("_______________");
            System.out.println("getContentType" + urlConnection.getContentType());
            System.out.println("getContentLength" + urlConnection.getContentLength());
            System.out.println("getContentEncoding" + urlConnection.getContentEncoding());
            System.out.println("getDate" + urlConnection.getDate());
            System.out.println("getExpiration" + urlConnection.getExpiration());
            System.out.println("getLastModified" + urlConnection.getLastModified());
            System.out.println("---------------");
            String encoding = urlConnection.getContentEncoding();
            if (encoding == null) {
                encoding = "UTF-8";
            }
            try (Scanner scanner = new Scanner(urlConnection.getInputStream(), encoding)) {
                for (int i = 1; scanner.hasNextLine() && i <= 10; i++) {
                    System.out.println(scanner.nextLine());
                }
                if (scanner.hasNextLine()) {
                    System.out.println(".....");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
