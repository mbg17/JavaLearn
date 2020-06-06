package C3P0;



import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo01 {
    public static void main(String[] args) throws SQLException {
        // 导入驱动
        // 配置配置文件，放在src目录下
        // 获取连接池对象
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        // 获取连接
        Connection connection = comboPooledDataSource.getConnection();
        System.out.println(connection);
        // 归还连接对象
        connection.close();
    }
}
