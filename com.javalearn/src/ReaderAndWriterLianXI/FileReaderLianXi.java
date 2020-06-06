package ReaderAndWriterLianXI;

import java.io.FileReader;
import java.io.IOException;

// 普通方式捕获异常
public class FileReaderLianXi {
    public static void main(String[] args) {
        FileReader fileReader = null;// 提升变量作用域
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader("D:\\JAVA\\com.javalearn\\src\\ReaderAndWriterLianXI\\demo.txt");
            int i = 0;
            // 读取单个字符
            while ((i = fileReader.read()) >= 1) {
                System.out.print((char) i);// 读取出的是对应的字节编码
            }
            // 通过char[]缓冲区读取多个字符
            fileReader2 = new FileReader("D:\\JAVA\\com.javalearn\\src\\ReaderAndWriterLianXI\\demo.txt");
            char[] chars = new char[1024];
            int len = 0;
            while ((len = fileReader2.read(chars)) >= 1) {
                System.out.print(new String(chars, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 创建成功才关闭IO流
            if (fileReader != null && fileReader2 != null) {
                try {
                    fileReader.close();
                    fileReader2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
