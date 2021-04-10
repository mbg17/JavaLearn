package com.test.database.translate.UrlConnection;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Mail {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        try (InputStream inputStream = Files.newInputStream(Paths.get("D:\\JAVA\\untitled\\src\\main\\resources"
                , "mail.properties"));) {
            properties.load(inputStream);
        }
        String from = "418556858@qq.com";
        String to = "798149519@qq.com";
        String subject = "sfsdfsdf";
        StringBuilder stringBuilder = new StringBuilder();

    }
}
