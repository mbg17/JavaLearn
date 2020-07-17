package com.itheima.mybatis.sqlsession.proxy;

import com.itheima.mybatis.cfg.Configuration;
import com.itheima.mybatis.cfg.Mapper;
import com.itheima.mybatis.utils.DataSourceUtil;
import com.itheima.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;

public class MapperProxy implements InvocationHandler {
    private Configuration cfg;
    private Connection conn;

    public MapperProxy(Configuration cfg,Connection conn) {
        this.cfg = cfg;
        this.conn = conn;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        String className = method.getDeclaringClass().getName();
        String key = className+"."+methodName;
        Mapper mapper = cfg.getMappers().get(key);
        return new Executor().selectList(mapper,conn);
    }
}
