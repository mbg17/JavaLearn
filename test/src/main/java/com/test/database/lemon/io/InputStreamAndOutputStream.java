package com.test.database.lemon.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class InputStreamAndOutputStream {
    public static void main(String[] args) throws IOException {
        File fileOne = new File("D:\\JAVA\\test\\src\\main\\java\\com\\test\\database\\lemon\\io\\fileOne");
        try (
                FileOutputStream fileOutputStream = new FileOutputStream(fileOne);
                FileInputStream fileInputStream = new FileInputStream(fileOne);
        ) {
            fileOutputStream.write("dsfsdf".getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write(50);
            fileOutputStream.write(97);
            fileOutputStream.flush();
            byte[] bytes = new byte[3];
            int result = 0;
            while ((result = fileInputStream.read(bytes)) != -1) {
                for (int i = 0; i < result; i++) {
                    System.out.println(String.valueOf(bytes[i]));
                }
                System.out.println(new String(bytes));
            }
        }
    }
}
