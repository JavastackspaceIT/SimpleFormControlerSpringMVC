package com.sfc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@ComponentScan({"com.sfc.dao","com.sfc.service"})
@PropertySource("classpath:db.properties")
public class RootConfig {
	@Autowired
	Environment enviroment;

	@Bean(autowire=Autowire.BY_TYPE)
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(enviroment.getProperty("driverclassname"));
		driverManagerDataSource.setUrl(enviroment.getProperty("url"));
		driverManagerDataSource.setUsername(enviroment.getProperty("username1"));
		driverManagerDataSource.setPassword(enviroment.getProperty("password"));
		return driverManagerDataSource;
	}
	
	@Bean(autowire = Autowire.BY_TYPE)
	public JdbcTemplate jdbcTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		return jdbcTemplate;
	}
	
	@Bean(name="platformTransactionManager")
	public PlatformTransactionManager platformTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager=new DataSourceTransactionManager(dataSource());
		return dataSourceTransactionManager;
	}
	
}