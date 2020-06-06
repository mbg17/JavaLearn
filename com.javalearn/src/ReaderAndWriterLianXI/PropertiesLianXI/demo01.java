package ReaderAndWriterLianXI.PropertiesLianXI;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class demo01 {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.setProperty("陆远","牛逼");
        properties.setProperty("孙笑川","二笔");
        properties.setProperty("蔡徐坤","傻逼");
        // 遍历集合
        for (String propertiesKey : properties.stringPropertyNames()) {
            System.out.println(propertiesKey+"="+properties.getProperty(propertiesKey));
        }
        // 写入文件
        properties.store(new FileWriter("D:\\JAVA\\com.javalearn\\src\\ReaderAndWriterLianXI\\demo.txt"),"save data");
        // 使用字节流写入文件
        // properties.store(new FileOutputStream("D:\\JAVA\\com.javalearn\\src\\ReaderAndWriterLianXI\\demo.txt"),"save data"); 无法写入中文

        // 读取文件
        properties.load(new FileReader("D:\\JAVA\\com.javalearn\\src\\ReaderAndWriterLianXI\\demo.txt"));
        // properties.load(new FileInputStream("D:\\JAVA\\com.javalearn\\src\\ReaderAndWriterLianXI\\demo.txt")); 无法写入中文
        for (String stringPropertyName : properties.stringPropertyNames()) {
            System.out.println(stringPropertyName+"="+properties.getProperty(stringPropertyName));
        }
    }
}
