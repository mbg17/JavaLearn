package com.test.database.translate.pathandfile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class PathAndFileLearn {
    private final static String FILE_PATH = "D:" + File.separator + "JAVA"
            + File.separator + "untitled" + File.separator + "src" + File.separator + "main" +
            File.separator + "resources";
    public static void main(String[] args) throws IOException {
        Path path = Paths.get(FILE_PATH + "/hehe.txt");
        // 写入单行
        Files.writeString(path,"jksjdfksjdf");
        List<String> strings = List.of("hashdahsd",
                "sdfsdfsdf",
                "sdfsdfsdf");
        // 追加写入多行
        Files.write(path,strings, StandardOpenOption.APPEND);
        // 读取多行
        List<String> strings1 = Files.readAllLines(path);
        for (String s : strings1) {
            System.out.println(s);
        }
    }
}
