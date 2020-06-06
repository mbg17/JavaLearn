package OutAndInputStreamReaderLianXi;

import java.io.*;

public class changCharset {
    public static void main(String[] args) throws IOException {
        // 定义两个转换流的字符缓冲流对象
        BufferedReader gbk = new BufferedReader(new InputStreamReader(new FileInputStream("com.javalearn\\src\\OutAndInputStreamReaderLianXi\\gbk.txt"), "GBK"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("com.javalearn\\src\\OutAndInputStreamReaderLianXi\\utf-8.txt"), "utf-8"));
        char[] chars = new char[1024];
        int len = 0;
        // 读取文件以utf8格式写入文件
        while ((len = gbk.read(chars)) >= 1) {
            bufferedWriter.write(chars, 0, len);
        }
        bufferedWriter.close();
        gbk.close();
    }
}
