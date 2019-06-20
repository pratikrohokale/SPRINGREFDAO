package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface EmployeeService {
	public EmployeeDTO searchEmployeeByNo(int no);
	public List<EmployeeDTO> searchEmployeesByDesgAndDeptNo(String desg,int deptno);
	public String registerEmployee(EmployeeDTO dto);

}
