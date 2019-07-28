package com.hibernate.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import lombok.Data;

@Data
@Configuration
@EnableTransactionManagement
public class DatabaseConfig {
	  
	  @Value("${db.driver}")
	  private String DB_DRIVER;
	  
	  @Value("${db.password}")
	  private String DB_PASSWORD;
	  
	  @Value("${db.url}")
	  private String DB_URL;
	  
	  @Value("${db.username}")
	  private String DB_USERNAME;

	  @Value("${hibernate.dialect}")
	  private String HIBERNATE_DIALECT;
	  
	  @Value("${hibernate.show_sql}")
	  private String HIBERNATE_SHOW_SQL;
	  
	  @Value("${hibernate.hbm2ddl.auto}")
	  private String HIBERNATE_HBM2DDL_AUTO;

	  @Bean
	  public DataSource dataSource() {
	    DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName(getDB_DRIVER());
	    dataSource.setUrl(getDB_URL());
	    dataSource.setUsername(getDB_USERNAME());
	    dataSource.setPassword(getDB_PASSWORD());
	    return dataSource;
	  }

	  @Bean
	  public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(dataSource());
	    sessionFactoryBean.setPackagesToScan("com.hibernate.entity");
	    Properties hibernateProperties = new Properties();
	    hibernateProperties.put("hibernate.dialect", getHIBERNATE_DIALECT());
	    hibernateProperties.put("hibernate.show_sql", getHIBERNATE_SHOW_SQL());
	    hibernateProperties.put("hibernate.hbm2ddl.auto", getHIBERNATE_HBM2DDL_AUTO());
	    sessionFactoryBean.setHibernateProperties(hibernateProperties);
	    
	    return sessionFactoryBean;
	  }

	  @Bean
	  public HibernateTransactionManager transactionManager() {
	    HibernateTransactionManager transactionManager = 
	        new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	  }

}
