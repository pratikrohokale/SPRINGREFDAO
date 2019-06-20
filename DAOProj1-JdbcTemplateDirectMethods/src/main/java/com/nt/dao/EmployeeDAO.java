package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmployeeDAO {
	public int getEmpsCount();
	public Map<String,Object> getEmpByNumber(int eno);
	public List<Map<String,Object>> getEmpsByDesg(String desg);
	public  int insert(int eno,String name,String desg,float salary);
	public  float getEmpSalaryByNo(int no);
	public int update(int eno,float newSalary);
	public int delete(int eno);

}
