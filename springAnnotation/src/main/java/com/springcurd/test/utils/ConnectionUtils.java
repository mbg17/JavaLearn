package com.springcurd.test.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
@Component("connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();
    @Autowired
    private DataSource datasourse;

    public Connection getConnettion(){
        Connection conn = tl.get();
        if(conn==null){
            try {
                conn = datasourse.getConnection();
                tl.set(conn);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return conn;
    }

    public void removeConnection(){
        tl.remove();
    }
}
