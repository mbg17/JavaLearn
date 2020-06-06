package OutputStreamLianXi.BufferedInputStreamAndBufferedOutputStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOut {
    public static void main(String[] args) throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\BufferedInputStreamAndBufferedOutputStream\\test.txt"));
        bufferedOutputStream.write("hahahahaah".getBytes());// 写入所有字符
        bufferedOutputStream.write("12345".getBytes(),2,3);// 写入部分字符
        bufferedOutputStream.flush();// 刷新内存数据到硬盘中
        bufferedOutputStream.close();
    }
}
