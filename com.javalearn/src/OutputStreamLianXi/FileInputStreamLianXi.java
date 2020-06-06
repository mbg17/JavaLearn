package OutputStreamLianXi;

import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamLianXi {
    public static void main(String[] args) throws IOException {
        // 创建一个字符读取流对象
        FileInputStream fileInputStream = new FileInputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\a.txt");
        // 读取单个字符
        // 使用while循环读取
        int i = 0;
        while((i=fileInputStream.read())!=-1){// 返回-1说明读取完毕
            System.out.println((char) i);// 将ascii码转换成原本的字符
        }
        fileInputStream.close();

        // 使用第二种方法读取多个数据
        FileInputStream fileInputStream2 = new FileInputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\a.txt");
        // 读取单个字符
        // 使用while循环读取
        int i2 = 0;
        byte[] bytes = new byte[1024];
        while((i2=fileInputStream2.read(bytes))>=1){// 返回值小于1说明读取完毕，返回的数字为读取的有效值
            System.out.println(new String(bytes,0,i2));// 使用String类的构造方法将byte[]转为为字符串
        }
        fileInputStream2.close();
    }
}
