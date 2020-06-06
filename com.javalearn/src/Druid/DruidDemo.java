package Druid;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DruidDemo {
    public static void main(String[] args) throws Exception {
        // 注册驱动
        // 编写配置文件
        // 创建Properties对象
        Properties properties = new Properties();
        // 使用类加载器返回配置文件的流对象
        InputStream resourceAsStream = DruidDemo.class.getClassLoader().getResourceAsStream("druid.properties");
        // 读取配置文件
        properties.load(resourceAsStream);
        // 通过配置文获取连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取连接对象
        Connection connection = dataSource.getConnection();
        String sql = "select * from emp where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,1001);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            System.out.println(resultSet.getString("ename"));
        }
        System.out.println(connection);
        // 归还连接对象
        connection.close();
        resourceAsStream.close();
    }
}
