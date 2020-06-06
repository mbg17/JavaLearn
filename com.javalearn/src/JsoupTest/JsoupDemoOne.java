package JsoupTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class JsoupDemoOne {
    public static void main(String[] args) throws IOException {
        // 获取xml文件路径，通过类加载器
        String path = JsoupDemoOne.class.getClassLoader().getResource("student.xml").getPath();
        // 获取Document对象
        Document jsoup = Jsoup.parse(new File(path),"utf-8");
        // 通过属性查找Element
        Elements name = jsoup.getElementsByAttribute("id");
        for (Element element : name) {
            System.out.println(element);
        }
        System.out.println("------------------");
        // 通过标签查找元素
        Elements property = jsoup.getElementsByTag("student");
        for (Element element : property) {
            System.out.println(element);
        }
        System.out.println("------------------");
        // 通过属性和值查找element
        Elements elementsByAttributeValue = jsoup.getElementsByAttributeValue("number", "heima_0002");
        for (Element element : elementsByAttributeValue) {
            System.out.println(element);
            System.out.println("------------------");
            // 通过对象获取属性值
            System.out.println(element.attr("number"));// 获取当前标签的属性值
            System.out.println(element.html());// 获取当前element的所有内容
            System.out.println(element.text());// 获取当前element的所有文本内容
        }

        Elements select = jsoup.select("student[number=\"heima_0002\"]");// 通过选择器获取Element，具体规则查看文档（Selector）
        System.out.println(select);
    }
}
