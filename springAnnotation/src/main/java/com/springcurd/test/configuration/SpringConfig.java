package com.springcurd.test.configuration;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 总配置类：
 *       ComponentScan：指定扫描包路径
 *       Import：导入配置子类（必须要写Configuration注解）
 *       EnableAspectJAutoProxy：开启aop事务
 *       EnableTransactionManagement:开启声明式事务控制
 */

@Configuration
@ComponentScan("com.springcurd.test")
@EnableAspectJAutoProxy
@Import({JdbcConfig.class,TransactionConfig.class})
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class SpringConfig {
}
