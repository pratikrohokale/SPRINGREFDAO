package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;

import com.nt.config.RootAppConfig;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;

@SpringBootApplication
@Import(value=RootAppConfig.class)
public class DaoBootProj18MappingSqlOperationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService stService=null;
		StudentDTO dto=null;
		//prepare DTO
		dto=new StudentDTO();
		dto.setSno(101); dto.setSname("new raja"); dto.setSadd("old hyd");
		//get Container
		ctx=SpringApplication.run(DaoBootProj18MappingSqlOperationsApplication.class, args);
		//get Bean
		stService=ctx.getBean("stService",StudentService.class);
		try{
		 System.out.println("101 details::"+stService.searchStudentByNo(101));
		 System.out.println("hyd Student details::"+stService.searchStudentByAddrs("hyd"));
		 System.out.println(stService.modifyStudentByNo(dto));
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
