package com.nt.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.ReservationDetailsDTO;
import com.nt.service.TicketReservationService;

public class BatchProcessingTest {
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		TicketReservationService service=null;
		int count=0;
		Scanner sc=null;
		String name=null,boardingFrom=null,destination=null;
		int age=0;
		ReservationDetailsDTO dto=null;
		List<ReservationDetailsDTO> listDTO=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("reservationService",TicketReservationService.class);
		//read passengers count
		sc=new Scanner(System.in);
		System.out.println("Passengers count::");
		count=sc.nextInt();
		
		//prepare ListDTO having passenger Details
		listDTO=new ArrayList();
		for(int i=1;i<=count;++i){
			System.out.println("Enter "+i+" passenger Details::");
			System.out.println("name::");
			name=sc.next();
			System.out.println("age");
			age=sc.nextInt();
			System.out.println("boardingFrom::");
			boardingFrom=sc.next();
			System.out.println("Destination::");
			destination=sc.next();
			//add each details  to DTO 
			dto=new ReservationDetailsDTO();
			dto.setName(name);dto.setAge(age); 
			dto.setBoardingFrom(boardingFrom);
			dto.setDestination(destination);
			listDTO.add(dto);
		}
		
		//invoke Method
		try{
		 System.out.println(service.groupReseveration(listDTO));	
		}
		catch(DataAccessException dae){
			dae.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}//main
}//class
