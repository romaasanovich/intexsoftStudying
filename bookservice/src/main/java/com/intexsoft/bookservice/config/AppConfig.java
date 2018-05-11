package com.intexsoft.bookservice.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@EnableJpaRepositories("com.intexsoft.bookservice.repository")
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("com.intexsoft.bookservice.repository"),
        @ComponentScan("com.intexsoft.bookservice.service"), @ComponentScan("com.intexsoft.bookservice.api")})
public class AppConfig {

    @Autowired
    private Environment env;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em
                = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan(new String[]{"com.intexsoft.bookservice.entity"});

        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        return em;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(env.getProperty("mysql.driverClassName"));
        dataSource.setUrl(env.getProperty("mysql.url"));
        dataSource.setUsername(env.getProperty("mysql.username"));
        dataSource.setPassword(env.getProperty("mysql.password"));
        return dataSource;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new JpaTransactionManager();
    }

    @Bean(initMethod = "migrate")
    Flyway flyway() {
        Flyway flyway = new Flyway();
        flyway.setBaselineOnMigrate(true);
        flyway.setLocations("db/migration");
        flyway.setDataSource(dataSource());
        return flyway;
    }


//    @Bean
//    public LocalSessionFactoryBean getSessionFactory() {
//        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
//
//        Properties props = new Properties();
//
//        // Setting JDBC properties
//        props.put(DRIVER, env.getProperty("mysql.driverClassName"));
//        props.put(URL, env.getProperty("mysql.url"));
//        props.put(USER, env.getProperty("mysql.username"));
//        props.put(PASS, env.getProperty("mysql.password"));
//
//        // Setting Hibernate properties
//        props.put(DIALECT, env.getProperty("hibernate.dialect"));
//        props.put(SHOW_SQL, env.getProperty("hibernate.show_sql"));
//        props.put(HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
//
//        // Setting C3P0 properties
//        props.put(C3P0_MIN_SIZE, env.getProperty("hibernate.c3p0.min_size"));
//        props.put(C3P0_MAX_SIZE, env.getProperty("hibernate.c3p0.max_size"));
//        props.put(C3P0_ACQUIRE_INCREMENT, env.getProperty("hibernate.c3p0.acquire_increment"));
//        props.put(C3P0_TIMEOUT, env.getProperty("hibernate.c3p0.timeout"));
//        props.put(C3P0_MAX_STATEMENTS, env.getProperty("hibernate.c3p0.max_statements"));
//
//        factoryBean.setHibernateProperties(props);
//        factoryBean.setAnnotatedClasses(Author.class, Book.class, Publisher.class);
//
//        return factoryBean;
//    }

//    @Bean
//    public HibernateTransactionManager getTransactionManager() {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(getSessionFactory().getObject());
//        return transactionManager;
//    }
}
