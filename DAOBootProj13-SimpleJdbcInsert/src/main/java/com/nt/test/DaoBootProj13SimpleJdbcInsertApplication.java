package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.dao.DataAccessException;

import com.nt.config.RootAppConfig;
import com.nt.dto.StudentDTO;
import com.nt.service.StudentService;
import com.nt.service.StudentServiceImpl;

@SpringBootApplication
@Import(value=RootAppConfig.class)
public class DaoBootProj13SimpleJdbcInsertApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		StudentService service=null;
		StudentDTO dto=null;
		//get Container
		ctx=SpringApplication.run(DaoBootProj13SimpleJdbcInsertApplication.class, args);
		//get Bean
		service=ctx.getBean("stService",StudentService.class);
		//prepare DTO
		dto=new StudentDTO();
		dto.setSno(1301); dto.setSname("Rajesh"); dto.setSadd("hyd");
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
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}
}
