package com.brico.ExtractToCsv.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "bookEntityManagerFactoryRed", basePackages = {
        "com.brico.ExtractToCsv.repo"}, transactionManagerRef = "bookTransactionManager")
public class BookDbConfig {

    @Bean(name = "bookDatasource")
    @ConfigurationProperties(prefix = "spring.book.datasource")
    public DataSource dataSource(){
        return DataSourceBuilder.create().build();
    }
    @Bean(name = "bookEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(
            EntityManagerFactoryBuilder builder,
            @Qualifier("bookDatasource") DataSource dataSource) {
        Map<String,Object> properties = new HashMap<>();
        properties.put("hibernate.ddl-auto","update");
        properties.put("hibernate.dialect","org.hibernate.dialect.MYSQL5Dialect");
        return builder.dataSource(dataSource).packages("com.brico.ExtractToCsv.model.book").persistenceUnit("Book").build();
    }

    @Bean(name = "bookTransactionManager")
    public PlatformTransactionManager transactionManager(@Qualifier("bookTransactionManager")EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
