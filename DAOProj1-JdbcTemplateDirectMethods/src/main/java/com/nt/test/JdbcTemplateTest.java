package com.nt.test;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeService;

public class JdbcTemplateTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeService service=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("empService",EmployeeService.class);
		try{
		//invoke the methods
		System.out.println("Emps Count::"+service.fetchEmpsCount());
		System.out.println("7499 Emp Details::"+service.fetchEmpByNumber(7499));
		System.out.println("CLERK Desg Emp Details:::"+service.fetchEmpsByDesg("CLERK"));
		//System.out.println("Emp Registered?"+service.register(1001, "raja", 8000,"CLERK"));
		System.out.println("Emp Salary hike?"+service.hikeSalary(1001,20));
		System.out.println("Emp Fired?"+service.fireEmp(1001));
		
		}
		catch(DataAccessException se){
			System.out.println("Internal DB problem");
			se.printStackTrace();
		}
		catch(Exception e){
			System.out.println("Unknown Problem");
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class
