package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.SearchEmployeeService;

public class CallbackInterfacesTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		SearchEmployeeService service=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empSearchService",SearchEmployeeService.class);
		try{
		//invoke method
		System.out.println("7499 Emp Details::"+service.searchEmployeeByNo(7499));
		System.out.println("CLERK Desg Emp Details::"+service.searchEmployeeByDesg("CLERK"));
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
