package FileLianXi;

import java.io.File;

public class Demo01 {
    public static void main(String[] args) {
        // 获取系统路径分割符
        System.out.println(File.pathSeparator);
        // 获取系统的文件分隔符
        System.out.println(File.separator);

        // 构造方法
        File file = new File("D:\\JAVA\\com.javalearn\\src\\FileLianXi");
        File demo01 = new File("D:\\JAVA\\com.javalearn\\src\\FileLianXi", "Demo01.java");
        File file1 = new File(file, "text.txt");

        // 获取绝对路径
        System.out.println(file.getAbsolutePath());
        // 获取路径（传的什么路径返回什么）
        System.out.println(file.getPath());
        // 获取路径最后的文件名或者文件夹名称
        System.out.println(file.getName());
        // 获取路径最后的文件的大小（文件夹没有大小）
        System.out.println(demo01.length());

        // 判断方法
        if(demo01.exists()){
            System.out.println(demo01.isDirectory());// 是否是文件夹
            System.out.println(demo01.isFile());// 是否是文件
        }
    }
}
