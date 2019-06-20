package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface EmployeeDAO {
	public EmployeeBO  getEmployeeByNo(int no);
	public List<EmployeeBO> getEmployeesByDesgAndDeptNo(String desg,int deptno);
	public  int insert(EmployeeBO bo);

}
