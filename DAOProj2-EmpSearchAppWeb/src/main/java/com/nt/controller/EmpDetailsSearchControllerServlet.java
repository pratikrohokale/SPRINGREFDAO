package com.nt.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.EmpDetailsSearchService;

public class EmpDetailsSearchControllerServlet extends HttpServlet {
	EmpDetailsSearchService service;
	ClassPathXmlApplicationContext ctx;
	
	public void init(){
	//create IOC container
	
	ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
	 //Get Bean
	service=ctx.getBean("empService",EmpDetailsSearchService.class);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      String desgs[]=null;
      List<Map<String,Object>> listMap=null;
      RequestDispatcher rd=null;
		//read form data
      desgs=req.getParameterValues("desg");
      //use Service
      listMap=service.findEmpDetailsByDesg(desgs);
      //keep results in request scope
      req.setAttribute("empList",listMap);
      //create RequestDispatcher
      rd=req.getRequestDispatcher("/result.jsp");
      rd.forward(req, res);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}
	
	@Override
	public void destroy() {
	   service=null;
	   ctx.close();
	}

}
