package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmployeeDAO;

public class EmployeeServiceImpl implements EmployeeService {
	
	private  EmployeeDAO dao;

	public void setDao(EmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public int fetchEmpsCount() {
		int count=0;
		//use DAO
		count=dao.getEmpsCount();
		return count;
	}
	
	@Override
	public Map<String, Object> fetchEmpByNumber(int eno) {
		Map<String,Object> map=null;
	      //use DAO
        map=dao.getEmpByNumber(eno);		
		return map;
	}
	
	@Override
	public List<Map<String, Object>> fetchEmpsByDesg(String desg) {
		List<Map<String,Object>> list=null;
		//use DAO
		list=dao.getEmpsByDesg(desg);
		return list;
	}
	
	@Override
	public String register(int no, String name, float sal, String desg) {
	   int count=0;
	   //use DAO
	   count=dao.insert(no, name, desg, sal);
	   if(count==0)
		   return "Emp Registration Failed";
	   else
		   return "Emp Registation succeded";
	}
	
	@Override
	public String hikeSalary(int no, float percentage) {
		float salary=0.0f;
		int count=0;
		//get salary
		salary=dao.getEmpSalaryByNo(no);
		//hike salary
		salary=salary+(salary*(percentage/100.0f));
		//update new salary
		count=dao.update(no,salary);
		if(count==1)
		  return "Emp salary is hiked to"+salary;
		else
			return "Emp salary is not hiked ";	
	}
	
	@Override
	public String fireEmp(int no) {
		int count=0;
		//use DAO
		count=dao.delete(no);
		if(count==0)
			return "Employee Not found to delete";
		else
			return "Employee  found for deletion";
	}

}
