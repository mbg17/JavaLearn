package com.test.database.lemon.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputReaderAndOutputReader {
    public static void main(String[] args) throws IOException {
        File fileOne = new File("D:\\JAVA\\test\\src\\main\\java\\com\\test\\database\\lemon\\io\\fileOne");
        try (
                FileWriter fileOutputStream = new FileWriter(fileOne);
                FileReader fileInputStream = new FileReader(fileOne);
        ) {
            fileOutputStream.write("dsfsdf");
            fileOutputStream.write(50);
            fileOutputStream.write(97);
            fileOutputStream.flush();
            char[] chars = new char[3];
            int result = 0;
            while ((result = fileInputStream.read(chars)) != -1) {
                for (int i = 0; i < result; i++) {
                    System.out.println(String.valueOf(chars[i]));
                }
                System.out.println(new String(chars));
            }
        }
    }
}
