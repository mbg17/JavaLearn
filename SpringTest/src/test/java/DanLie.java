import com.spring.test.service.impl.AccountServiceImpl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DanLie {
    public static void main(String[] args) {
        for (int i = 0; i < 5 ; i++) {
            AccountServiceImpl accountServicename =(AccountServiceImpl) BeanFactory.getBean("accountServicename");
            System.out.println(accountServicename);
        }
    }
}

class BeanFactory{
    private static Properties pro;
    private static Map<String,Object> map;
    static{
        pro = new Properties();
        map = new HashMap<>();
        InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beanFactory.properties");
        try {
            pro.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Enumeration<Object> keys = pro.keys();
        while(keys.hasMoreElements()){
            String key = keys.nextElement().toString();
            String o = (String) pro.get(key);
            try {
                // 反射通过无参构造方法获取对象
                Object value = Class.forName(o).newInstance();
                map.put(key,value);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static Object getBean(String bean){
        return map.get(bean);
    }

}