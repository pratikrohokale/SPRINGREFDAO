package com.nt.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.jndi.JndiObjectFactoryBean;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan(basePackages="com.nt.dao")
public class PersistenceConfig {
	
	
/*	@Bean
	public JndiObjectFactoryBean createJOFB(){
		JndiObjectFactoryBean jofb=null;
		jofb=new JndiObjectFactoryBean();
		jofb.setJndiName("java:/comp/env/DsJndi");
	     return jofb;
	}
	
	@Bean
	public DataSource createDataSource(){
		return (DataSource) createJOFB().getObject();
	}*/
	
	
	@Bean
	public  DataSource  getDataSource(){
		JndiDataSourceLookup jdsl=null;
		DataSource ds=null;
		jdsl=new JndiDataSourceLookup();
		ds=jdsl.getDataSource("java:/comp/env/DsJndi");
		return ds;
	}
	
	
	@Bean
	public  SimpleJdbcCall createSJCall()throws Exception{
		return new  SimpleJdbcCall(getDataSource());
	}
	
	

}
