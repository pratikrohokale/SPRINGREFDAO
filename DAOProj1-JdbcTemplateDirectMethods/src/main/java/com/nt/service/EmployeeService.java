package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmployeeService {
	
	public int  fetchEmpsCount();
	public Map<String,Object> fetchEmpByNumber(int eno);
	public List<Map<String,Object>> fetchEmpsByDesg(String desg);
	public String register(int no,String name,float sal,String desg);
	public String hikeSalary(int no,float percentage);
	public String fireEmp(int no);

}
