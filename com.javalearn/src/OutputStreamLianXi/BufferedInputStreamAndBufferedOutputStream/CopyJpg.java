package OutputStreamLianXi.BufferedInputStreamAndBufferedOutputStream;

import java.io.*;

public class CopyJpg {
    public static void main(String[] args) {
        try(BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\BufferedInputStreamAndBufferedOutputStream\\1.jpg"));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\BufferedInputStreamAndBufferedOutputStream\\copy.jpg"));){
            long s = System.currentTimeMillis();

            byte[] bytes = new byte[1024];
            int len =0;
            while((len = bufferedInputStream.read(bytes))>=1){
                bufferedOutputStream.write(bytes,0,len);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            bufferedInputStream.close();
            long e = System.currentTimeMillis();
            System.out.println("执行了"+(e-s)+"毫秒");
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
