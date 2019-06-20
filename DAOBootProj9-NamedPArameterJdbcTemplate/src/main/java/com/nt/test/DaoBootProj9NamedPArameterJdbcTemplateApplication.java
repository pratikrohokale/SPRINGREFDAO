package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.config.PersistenceConfig;
import com.nt.config.ServiceConfig;
import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;

@SpringBootApplication
@Import(value = { ServiceConfig.class, PersistenceConfig.class })
public class DaoBootProj9NamedPArameterJdbcTemplateApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = null;
		EmployeeService service = null;
		EmployeeDTO dto = null;

		ctx = SpringApplication.run(DaoBootProj9NamedPArameterJdbcTemplateApplication.class, args);
		// prepare DTO
		dto = new EmployeeDTO();
		dto.setNo(1202);
		dto.setEname("raja");
		dto.setJob("CLERK");
		dto.setSalary(80000);

		// get Bean
		service = ctx.getBean("empService", EmployeeService.class);
		try {
			// invoke the methods
			System.out.println("7499 Emp Details::" + service.searchEmployeeByNo(7499));
			System.out.println("10 Dept CLERK DEtails" + service.searchEmployeesByDesgAndDeptNo("CLERK", 10));
			System.out.println(service.registerEmployee(dto));
		} catch (DataAccessException se) {
			System.out.println("Internal DB problem");
			se.printStackTrace();
		} catch (Exception e) {
			System.out.println("Unknown Problem");
			e.printStackTrace();
		}
		// close container
		((AbstractApplicationContext) ctx).close();

	}// main
}// class
