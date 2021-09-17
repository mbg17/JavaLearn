package com.example.bugs.common;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.bugs.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Resource
    private HttpSession httpSession;

    @Override
    public void insertFill(MetaObject metaObject) {
        Date date = new Date();
        User user = (User) httpSession.getAttribute("user");
        this.fillStrategy(metaObject, "createBy", user==null?"":user.getNickname());
        this.fillStrategy(metaObject, "modifyBy", user==null?"":user.getNickname());
        this.fillStrategy(metaObject, "createTime", date);
        this.fillStrategy(metaObject, "updateTime", date);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "updateTime", new Date());
    }
}
