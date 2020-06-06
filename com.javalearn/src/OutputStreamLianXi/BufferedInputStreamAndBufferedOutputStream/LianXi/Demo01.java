package OutputStreamLianXi.BufferedInputStreamAndBufferedOutputStream.LianXi;

import java.io.*;
import java.util.*;

public class Demo01 {
    public static void main(String[] args) throws IOException {
        // 创建字符缓冲流输入输出对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\BufferedInputStreamAndBufferedOutputStream\\LianXi\\csb.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\BufferedInputStreamAndBufferedOutputStream\\LianXi\\csb2.txt"));
        ArrayList<String> words =new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine())!=null) {// 读取每一行，没有值返回null
            words.add(line);
        }
        Collections.sort(words);
        for (String word : words) {
            bufferedWriter.write(word);
            bufferedWriter.newLine();// 写入换行符
        }
        // 释放资源
        bufferedWriter.close();
        bufferedReader.close();
    }
}
