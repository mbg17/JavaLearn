package com.springcurd.test.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configurable
public class TransactionConfig {
    @Bean(name="transactionManager")
    public PlatformTransactionManager createTransactionManager( DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
