package com.test.database.lemon.io;

import java.io.File;

public class PrintFiles {
    public static void main(String[] args) {
        print(new File("C:\\Users\\陆远\\Desktop\\练习\\bugs"), "");
    }

    public static void print(File file, String s) {
        if (file.isDirectory()) {
            System.out.println(s + "/" + file.getName());
            for (File listFile : file.listFiles()) {
                if (listFile.getName().equals("node_modules") || listFile.getName().equals(".git")) {
                    continue;
                }
                print(listFile, s + "  ");
            }
        } else {
            System.out.println(s + file.getName());
        }
    }
}
