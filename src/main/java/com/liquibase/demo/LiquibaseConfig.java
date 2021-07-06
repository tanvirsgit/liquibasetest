package com.liquibase.demo;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/demo");
        dataSource.setUsername("root");
        dataSource.setPassword("Dipro@123456");

        return dataSource;
    }

    @Bean
    public SpringLiquibase liquibase(){
        SpringLiquibase springLiquibase = new SpringLiquibase();
        springLiquibase.setChangeLog("changeLog.sql");
        springLiquibase.setDataSource(dataSource());

        return springLiquibase;
    }

   /* @Bean
    public LocalSessionFactoryBean sessionFactoryBean(){
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.liquibase.demo");
        sessionFactoryBean.setHibernateProperties(properties());

        return sessionFactoryBean;
    }

    @Bean
    public Properties properties(){
        Properties properties = new Properties();
        properties.setProperty(AvailableSettings.HBM2DDL_AUTO,"update");
        properties.setProperty(AvailableSettings.DIALECT, MySQL55Dialect.class.getName());

        return properties;
    }*/

}
