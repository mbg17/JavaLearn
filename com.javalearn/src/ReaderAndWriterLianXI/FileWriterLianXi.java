package ReaderAndWriterLianXI;

import java.io.FileWriter;
import java.io.IOException;

// 使用JDK7新特性捕获异常
public class FileWriterLianXi {
    public static void main(String[] args) {
        try (FileWriter fileWriter = new FileWriter("D:\\JAVA\\com.javalearn\\src\\ReaderAndWriterLianXI\\demo.txt", true);) {
            char[] chars = {'a', 'b', 'c', 'v'};
            fileWriter.write(97);// 用字节编码写入单个字符
            fileWriter.write("哈哈哈");// 写入字符串
            fileWriter.write(chars);// 写入字符数组
            fileWriter.write("测试嘿嘿和", 2, 3);// 写入部分字符串
            fileWriter.write(chars, 2, 1);// 写入部分字符数组
            fileWriter.write("\r\n");// 写入回车

            fileWriter.flush();// 刷新内存数据到文件中
        } catch (IOException e) {
            e.printStackTrace();
        }
        // fileWriter.close();// 释放资源
    }
}
