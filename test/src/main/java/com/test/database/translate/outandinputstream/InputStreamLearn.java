package com.test.database.translate.outandinputstream;

import java.io.*;

public class InputStreamLearn {
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("D:" + File.separator + "JAVA"
                + File.separator + "untitled" + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "test.txt");
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(fileInputStream));
//        String s = dataInputStream.readUTF();
        int i;
        System.out.println(dataInputStream);
        while ((i = dataInputStream.read()) != -1) {
            System.out.print((char) i);
        }
        fileInputStream.close();
        dataInputStream.close();
    }
}
