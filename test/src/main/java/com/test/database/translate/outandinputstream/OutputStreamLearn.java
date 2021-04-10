package com.test.database.translate.outandinputstream;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class OutputStreamLearn {
    public static void main(String[] args) throws IOException {
        // 输入到文件 指定字符类型 自动冲刷
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("D:" + File.separator +
                "JAVA" + File.separator + "untitled" + File.separator + "src" + File.separator + "main" +
                File.separator + "resources" + File.separator + "test.txt")
                , StandardCharsets.UTF_8), true);
        printWriter.print("hhhahd");
        printWriter.print("2323");
        printWriter.print("1231");
        printWriter.print("3434");
        printWriter.checkError();
        printWriter.close();
    }
}
