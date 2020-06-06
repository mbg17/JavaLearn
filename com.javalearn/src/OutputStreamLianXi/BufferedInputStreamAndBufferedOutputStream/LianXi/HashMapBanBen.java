package OutputStreamLianXi.BufferedInputStreamAndBufferedOutputStream.LianXi;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class HashMapBanBen {
    public static void main(String[] args) throws IOException {
        // 创建字符缓冲流输入输出对象
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\BufferedInputStreamAndBufferedOutputStream\\LianXi\\csb.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\BufferedInputStreamAndBufferedOutputStream\\LianXi\\csb2.txt"));
        HashMap<String,String> map = new HashMap<>();
        String line;
        while ((line = bufferedReader.readLine())!=null) {// 读取每一行，没有值返回null
            String[] split = line.split("\\.");
            map.put(split[0],split[1]);
        }
        for (String s : map.keySet()) {
            bufferedWriter.write(s+"."+map.get(s));
            bufferedWriter.newLine();
        }
        // 释放资源
        bufferedWriter.close();
        bufferedReader.close();
    }
}
