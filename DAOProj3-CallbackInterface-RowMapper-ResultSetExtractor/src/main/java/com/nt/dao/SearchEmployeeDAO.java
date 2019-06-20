package com.nt.dao;

import java.util.List;

import com.nt.bo.EmployeeBO;

public interface SearchEmployeeDAO {
	public  EmployeeBO  findEmployeeByNo(int no);
	public  List<EmployeeBO> findEmployeesByDesg(String desg);

}
