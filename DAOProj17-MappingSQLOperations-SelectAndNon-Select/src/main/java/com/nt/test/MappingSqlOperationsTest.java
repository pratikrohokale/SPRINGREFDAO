package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;

public class MappingSqlOperationsTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		StudentDTO dto=null;
		//create IOC container
		ctx=new  ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("stService",StudentServiceImpl.class);
		//prpeare DTO
		dto=new StudentDTO();
		dto.setSno(1201); dto.setSname("new raja"); dto.setSadd("new hyd");
		//invoke methods
		try{
			System.out.println(service.searchStudentByNo(1201));
			System.out.println("-----------------------------");
			System.out.println(service.searchStudentByAddrs("hyd"));
			System.out.println("-------------------------------");
			System.out.println(service.modifyStudentByNo(dto));
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}//main
}//class
