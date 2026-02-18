package com.example.demo.config;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import jakarta.persistence.EntityManagerFactory;
@Configuration
@EnableJpaRepositories(
    basePackages = "com.example.demo.repo.h2",
    entityManagerFactoryRef = "h2EntityManagerFactory",
    transactionManagerRef   = "h2TransactionManager"
)
public class H2Config{
    @Primary
    @Bean(name = "h2DataSource")
    @ConfigurationProperties(prefix = "spring.h2.datasource")
    public DataSource h2DataSource() {
        return DataSourceBuilder.create().build();
    }
 
    @Primary
    @Bean(name = "h2EntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean h2EntityManagerFactory(
            @Qualifier("h2DataSource") DataSource dataSource) {
 
        LocalContainerEntityManagerFactoryBean em =
                new LocalContainerEntityManagerFactoryBean();
 
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.example.demo.entity");
 
        HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(adapter);
 
        HashMap<String, Object> props = new HashMap<>();
        props.put("hibernate.hbm2ddl.auto", "update");//spring.jpa.hibernate.ddl-auto=update
        props.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

        em.setJpaPropertyMap(props);
 
        return em;
    }
 
    @Primary
    @Bean(name = "h2TransactionManager") 
    public PlatformTransactionManager h2TransactionManager(
            @Qualifier("h2EntityManagerFactory")
            LocalContainerEntityManagerFactoryBean factory) {
        return new JpaTransactionManager(factory.getObject());
    }

       
}


