package com.test.database.lemon.io;

import java.io.*;

public class CopyFile {
    public static void main(String[] args) throws IOException {
        File a = new File(args[0]);
        File b = new File(args[1]);
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(a));
             OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(b));
        ) {
            char[] chars = new char[3];
            int result = 0;
            while ((result = inputStreamReader.read(chars)) != -1) {
                for (int i = 0; i < result; i++) {
                    outputStreamWriter.write(chars[i]);
                }
            }
        }
    }
}
