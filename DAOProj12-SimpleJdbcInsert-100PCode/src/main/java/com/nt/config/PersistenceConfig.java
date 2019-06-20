package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	
	@Bean
	public DataSource createDataSource()throws Exception{
		ComboPooledDataSource c3P0ds=null;
		c3P0ds=new ComboPooledDataSource();
		c3P0ds.setDriverClass("oracle.jdbc.driver.OracleDriver");
		c3P0ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
		c3P0ds.setUser("system");
		c3P0ds.setPassword("manager");
		return c3P0ds;
	}
	
	@Bean
	public  SimpleJdbcInsert createSJInsert()throws Exception{
		return new  SimpleJdbcInsert(createDataSource());
	}
	
	

}
