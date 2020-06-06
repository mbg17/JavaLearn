package JsoupTest;

import cn.wanghaomiao.xpath.exception.XpathSyntaxErrorException;
import cn.wanghaomiao.xpath.model.JXDocument;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsoupXpathDemo {
    public static void main(String[] args) throws IOException, XpathSyntaxErrorException {
        String path = JsoupDemoOne.class.getClassLoader().getResource("student.xml").getPath();
        // 获取Document对象
        Document jsoup = Jsoup.parse(new File(path),"utf-8");
        // 获取JXdocument对象
        JXDocument jxDocument = new JXDocument(jsoup);
        // 通过Xpath获取node信息
        List<Object> sel = jxDocument.sel("//student/name[@id='itcast']");// Xpath具体写法参考W3C文档
        for (Object o : sel) {
            System.out.println(o);
        }
    }
}
