package OutputStreamLianXi.BufferedInputStreamAndBufferedOutputStream;

import java.io.*;

public class BufferIn {
    public static void main(String[] args) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\BufferedInputStreamAndBufferedOutputStream\\test.txt"));
        byte[] bytes = new byte[1024];
        int len =0;
        while((len = bufferedInputStream.read(bytes))>=1){
            System.out.println(new String(bytes,0,len));
        }
        bufferedInputStream.close();
    }
}
