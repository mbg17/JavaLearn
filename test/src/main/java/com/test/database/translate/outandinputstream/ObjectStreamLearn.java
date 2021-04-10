package com.test.database.translate.outandinputstream;

import lombok.*;

import java.io.*;
import java.nio.charset.StandardCharsets;

/***
 * @author 陆远
 * @date 20210328
 * @apiNote 序列化对象
 */
public class ObjectStreamLearn {
    private final static String FILE_PATH = "D:" + File.separator + "JAVA"
            + File.separator + "untitled" + File.separator + "src" + File.separator + "main" +
            File.separator + "resources";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var objectOutputStream = new ObjectOutputStream(
                new FileOutputStream(FILE_PATH + File.separator + "objectdata.txt"));
        var people = new People("hehe", 1, "man");
        objectOutputStream.writeObject(people);
        objectOutputStream.close();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(FILE_PATH + File.separator + "objectdata.txt"));
        People o = (People) objectInputStream.readObject();
        System.out.println(o);
        objectInputStream.close();
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    @ToString
    /**
     *  序列化对象必须继承序列化接口Serializable
     */
    public static class People implements Serializable {
        private String name;
        private Integer id;
        private String sex;
    }
}
