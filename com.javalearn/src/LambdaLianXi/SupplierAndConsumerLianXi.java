package LambdaLianXi;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierAndConsumerLianXi {
    public static void main(String[] args) {
        String[] arr = {"陆远,男","张三,女"};
        consoleMsg(arr,(String[] array)-> System.out.print("姓名: "+array[0]),(String[] array)-> System.out.println(" 性别: "+array[1]));
        useData(produceData(()->"haha"),(String name)-> System.out.println(name));
        useData(produceData(()->"haha"),(String name)-> System.out.println(name),(String name)-> System.out.println(name+"1"));
    }

    // 生产型接口Supplier，返回指定类型的数据
    public static String produceData(Supplier<String> sp){
        return sp.get();
    }

    // 消费型接口Consumer，消费指定类型的数据
    public  static void useData(String s , Consumer<String> cm){
        cm.accept(s);
    }

    // andThen链接多个消费性接口使用数据
    public  static void useData(String s , Consumer<String> cm, Consumer<String> cm2){
        // 谁写在前面谁先用
        cm.andThen(cm2).accept(s);
    }

    public static void consoleMsg(String[] arr,Consumer<String[]> cm1,Consumer<String[]> cm2){
        for (String s : arr) {
            String[] split = s.split(",");
            cm1.andThen(cm2).accept(split);
        }
    }
}
