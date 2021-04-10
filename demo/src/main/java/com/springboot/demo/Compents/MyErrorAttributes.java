package com.springboot.demo.Compents;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * 自定义异常处理器转发异常信息后由该组件返回页面信息或者json数据
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> errorAttributes = new HashMap<>();
        Map<String, Object> response = (Map<String, Object>) webRequest.getAttribute("response", 0);
        if(response!=null){
            for (Map.Entry<String, Object> stringObjectEntry : response.entrySet()) {
                errorAttributes.put(stringObjectEntry.getKey(),stringObjectEntry.getValue());
            }
        }
        return errorAttributes;
    }
}
