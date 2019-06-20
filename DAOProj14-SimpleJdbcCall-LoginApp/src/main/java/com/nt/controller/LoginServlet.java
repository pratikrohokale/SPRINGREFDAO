package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.dto.UserDTO;
import com.nt.service.LoginService;

public class LoginServlet extends HttpServlet {
	ApplicationContext ctx=null;
	LoginService service=null;
	public void init(){
		//create IOC contianer
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("loginService",LoginService.class);
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		    String name=null,pass=null;
		    UserDTO dto=null;
		    String result=null;
		    RequestDispatcher rd=null;
		  
		    //read form data
		    name=req.getParameter("name");
		    pass=req.getParameter("pass");
		    //Stroe Form data into DTO class object
		    dto=new UserDTO();
		    dto.setUname(name);
		    dto.setPwd(pass);
		    //use Service.
		    result=service.validate(dto);
		    //keep result in request scope
		    req.setAttribute("res",result);
		    //forward to login.jsp
		    rd=req.getRequestDispatcher("/login.jsp");
		    rd.forward(req,res);
	}//doGet(-,-)
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		  doGet(req,res);
	}//doPost(-,-)
	
	@Override
	public void destroy() {
	   service=null;
	   ((PrintWriter) ctx).close();
	
	}
	
}//class
