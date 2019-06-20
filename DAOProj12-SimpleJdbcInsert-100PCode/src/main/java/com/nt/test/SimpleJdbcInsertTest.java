package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.RootAppConfig;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		StudentDTO dto=null;
		//create IOC container
		ctx=new  AnnotationConfigApplicationContext(RootAppConfig.class);
		//get Bean
		service=ctx.getBean("stService",StudentServiceImpl.class);
		//prpeare DTO
		dto=new StudentDTO();
		dto.setSno(2501);dto.setSname("raja"); dto.setSadd("hyd");
		//invoke method
		try{
			System.out.println(service.registerStudent(dto));
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//main
}//class
