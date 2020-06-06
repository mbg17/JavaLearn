package FileLianXi;

import java.io.File;

public class reviewFiles {
    public static void main(String[] args) {
//        listFiles(new File("D:\\JAVA\\com.javalearn\\src\\FileLianXi"));
        listFileEndwithJava(new File("D:\\JAVA\\com.javalearn\\src\\FileLianXi"));
    }

    // 递归浏览多级目录
    public static void listFiles(File file){
        if(file.exists()){
            // 使用FileFileter lambda方式来过滤文件
            for (File listFile : file.listFiles(path-> path.getName().endsWith(".java"))) {
                if(listFile.isDirectory()){
                    listFiles(listFile);
                }else {
                    System.out.println(listFile);
                }
            }
        }
    }

    // 只要.java的文件
    public static void listFileEndwithJava(File file){
        if(file.exists()){
            // 使用FilenameFileter lambda方式来过滤文件 dir - 找到该文件的目录。
            //name - 文件的名称。
            for (File listFile : file.listFiles((path,name)->new File(path,name).getName().endsWith(".java"))) {
                if(listFile.isDirectory()){
                    listFileEndwithJava(listFile);
                }else {
                        System.out.println(listFile);
                }
            }
        }
    }
}
