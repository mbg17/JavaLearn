package com.springcurd.test.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.management.Query;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * 数据源配置类：
 *      Configurable：指定当前类为配置类
 *      PropertySource：读取配置文件的路径
 *          classpath：表示在类文件下查找
 *      Value：给基本类型赋值支持el表达式
 *      Bean：指定bean标签属性：name 指定id 默认为当前方法名
 *      Qualifier:指定使用哪个bean对象
 */
@Configurable
public class JdbcConfig {

    @Value("${user}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;

    @Bean(name="jdbcTemplate")
    @Scope("prototype")
    public JdbcTemplate createJdbctemplate(@Qualifier("dataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name="runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("dataSource") DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

//    @Bean(name="proxyAccountService")
//    public AccountService createAAccountService(@Qualifier("factoryBean")FactoryBean factoryBean){
//        return factoryBean.getAccountService();
//    }

    @Bean(name="dataSource")
    public DataSource createDataSource() {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        try {
            ds.setUser(username);
            ds.setPassword(password);
            ds.setJdbcUrl(url);
            ds.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return ds;
    }

}
