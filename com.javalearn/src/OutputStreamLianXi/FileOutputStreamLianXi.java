package OutputStreamLianXi;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamLianXi {
    public static void main(String[] args) throws IOException {
        // 创建一个文件输出流对象，传入文件写入的地址,第二个参数为续写开关
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\a.txt",true);
        // 写入单个数据 整数查ascii码表 负数两个两个组合查系统默认码表
        fileOutputStream.write(97);
        // 写入换行符
        fileOutputStream.write("\r\n".getBytes());// getBytes 将字符串转为byte[]
        // 写入多个字符
        fileOutputStream.write("陆远牛逼的类".getBytes());
        // 关闭字符输出流，释放资源
        fileOutputStream.close();
    }
}
