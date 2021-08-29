package com.example.springboot.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Resource
    private HttpSession httpSession;

    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "createBy", this.getUserId());
        this.fillStrategy(metaObject, "updateBy", this.getUserId());
        Date date = new Date();
        this.fillStrategy(metaObject, "createTime", date);
        this.fillStrategy(metaObject, "updateTime", date);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "updateBy", this.getUserId());
        this.fillStrategy(metaObject, "updateTime", new Date());
    }

    private Integer getUserId() {
        Integer userId = (Integer) httpSession.getAttribute("userId");
        if (userId == null) {
            return -1;
        }
        return userId;
    }
}
