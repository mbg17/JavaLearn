package com.test.database.translate.xmllearn;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class XpathLearn {
    public static void main(String[] args) throws IOException, XPathExpressionException, ParserConfigurationException, SAXException {
        List<String> strings = Files.readAllLines(Paths.get("D:\\JAVA\\untitled\\src\\main\\resources\\copy\\h.html"), StandardCharsets.UTF_8);
        String s = "";
        for (String string : strings) {
            s += string;
        }
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document parse = documentBuilder.parse("D:\\JAVA\\untitled\\src\\main\\resources\\test.xml");
        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();
        String evaluate = xPath.evaluate("/class", parse);
        System.out.println(evaluate);
    }
}
