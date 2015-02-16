package com.capgemini.StarterKit.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.capgemini.StarterKit.service.GreetingService;
import com.capgemini.StarterKit.service.ZipCodeService;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import java.util.Properties;


@EnableJpaRepositories(basePackages = "com.capgemini.StarterKit.repository")
@ComponentScan(value = {"com.capgemini.StarterKit.controller,"
					  + "com.capgemini.StarterKit.service,"
					  + "com.capgemini.StarterKit.repository"})
@Configuration
public class TestConfig extends WebMvcConfigurerAdapter {

	
    @Bean(initMethod = "init")
    public GreetingService greetingService() {
       return new GreetingService();
       
    }

    @Bean(initMethod = "init")
    public ZipCodeService zipCodeService() {
       return new ZipCodeService();
       
    }
	
	@Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/ELECTION_DATABASE");
        dataSource.setUsername("postgresJavaConnection");
        dataSource.setPassword("12rafal90");
        return dataSource;
    }
	
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }


    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.capgemini.StarterKit.entities");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        em.setJpaProperties(hibernateProperties());
        em.afterPropertiesSet();
        return em;
    }

    @Bean
    public Properties hibernateProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("hibernate.show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        return properties;
    }

}
