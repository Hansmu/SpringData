package com.git.spring.data;

import javafx.application.Platform;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration //To specify to Spring that we'll be defining beans within this class.
@EnableJpaRepositories("com.git.spring.data") //Specify where to find our repositories.
@EnableTransactionManagement //So we can use the transactional annotation on our methods.
@ComponentScan("com.git.spring.data") //Find our beans
public class DataConfiguration {

    @Bean //Returns a bean for us.
    public DataSource dataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder(); //To construct our datasource
        return builder.setType(EmbeddedDatabaseType.H2).build(); //Creates an embedded datasource
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true); //Tells the JPA vendor implementation to automatically construct our tables.
        Properties jpaProperties = new Properties();
        //Tells Hibernate to auto-generate our DDL and what approach to use.
        jpaProperties.put("hibernate.hbm2ddl.auto", "create-drop"); //Create the tables once we start the application and drop them ocne we close the application.
        //Tell hibernate what vendor we're using so it can
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.HSQLDialect"); //Properly format our SQL:
        jpaProperties.put("hibernate.hbm2ddl.import_files", "init.sql"); //Files that will be run after the DDL has been created.

        //Will build our entity manager factory.
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(dataSource());
        factory.setPackagesToScan("com.git.spring.data"); //Which package contains our entities.
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setJpaProperties(jpaProperties);
        factory.afterPropertiesSet(); //Method on the initializing bean interface that the factory implements.

        return factory.getObject(); //returns the actual entity manager factory.
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory()); //So we can persist in transactions.
        return txManager;
    }
}
