package OutputStreamLianXi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPic {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        FileInputStream fileInputStream = new FileInputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\a.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\copya.jpg",true);
        byte[] bytes = new byte[1024];// 定义read缓冲区
        int i=0;//判断是否读取完成标记
        File f = new File("D:\\JAVA\\com.javalearn\\src\\OutputStreamLianXi\\copya.jpg");
        // 循环写入文件
        if(f.exists()){
            f.delete();
            System.out.println("删除完成");
        }
        while((i=fileInputStream.read(bytes))>=1){
            fileOutputStream.write(bytes,0,i);
        }
        fileOutputStream.close();
        fileInputStream.close();
        long e = System.currentTimeMillis();
        System.out.println("执行了"+(e-s)+"毫秒");
    }
}
