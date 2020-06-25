package test.Web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.*;

/**
 * @author 陆远
 */
@WebFilter(filterName = "SensitiveWordFilter",value = "/*")
public class SensitiveWordFilter implements Filter {
    private List<String> words = new ArrayList<String>();
    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ServletRequest proxy_req = (ServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(), req.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            /*
            proxy:代理对象
            method:代理对象调用的方法对象
            args：参数列表
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                if ("getParameter".equals(method.getName())) {
                    String arg = (String) method.invoke(req,args);
                    if(arg!=null){
                        for (String word : words) {
                            if(arg.contains(word)){
                                String s = arg.replaceAll(word, "***");
                                arg=s;
                            }
                        }
                    }
                    return arg;
                } else if ("getParameterValues".equals(method.getName())) {
                    String[] invoke = (String[]) method.invoke(req, args);
                    if(invoke!=null){
                        for (int i = 0; i < invoke.length; i++) {
                            for (String word : words) {
                                if(invoke[i].contains(word)){
                                    String s = invoke[i].replaceAll(word, "***");
                                    invoke[i]=s;
                                }
                            }
                        }
                    }
                    return invoke;
                } else if ("getParameterMap".equals(method.getName())) {
                    Map<String, String[]> invoke = (Map<String, String[]>) method.invoke(req, args);
                    Map<String, String[]> newMap = new HashMap<>();
                    if(invoke!=null){
                        Set<String> strings = invoke.keySet();
                        for (String string : strings) {
                            String[] stringList = invoke.get(string);
                            String s = invoke.get(string)[0];
                            for (String word : words) {
                                if(s.contains(word)){
                                    stringList[0] = s.replaceAll(word, "***");
                                    System.out.println(stringList[0]);
                                }
                                newMap.put(string, stringList);
                            }
                        }
                        return newMap;
                    }
                    return invoke;
                }
                return method.invoke(req, args);
            }
        });
        chain.doFilter(proxy_req, resp);
    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        words.add("笨蛋");
        words.add("傻子");
    }

}
