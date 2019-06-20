package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.EmployeeBO;
import com.nt.dao.EmployeeDAO;
import com.nt.dto.EmployeeDTO;

@Service("empService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;


	@Override
	public EmployeeDTO searchEmployeeByNo(int no) {
		EmployeeDTO dto=null;
		EmployeeBO bo=null;
		//use DAO
		bo=dao.getEmployeeByNo(no);
		//copy BO to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		return dto;
	}

	@Override
	public List<EmployeeDTO> searchEmployeesByDesgAndDeptNo(String desg, int deptno) {
		List<EmployeeBO> listBO=null;
		List<EmployeeDTO> listDTO=new ArrayList();
		
		//use dAO
		listBO=dao.getEmployeesByDesgAndDeptNo(desg,deptno);
		//Copy ListBO to ListDTO
		listBO.forEach(bo->{
			EmployeeDTO dto=null;
			dto=new EmployeeDTO();
			BeanUtils.copyProperties(bo,dto);
			listDTO.add(dto);
		});
		return listDTO;
	}//method
	
	@Override
	public String registerEmployee(EmployeeDTO dto) {
		EmployeeBO bo=null;
		int count=0;
		//convert DTO to BO
		bo=new EmployeeBO();
		BeanUtils.copyProperties(dto, bo);
		//use dAO
		count=dao.insert(bo);
		if(count==0)
			return "Registration failed";
		else
			return "Registraion succeded";
	}//method
	
}//class
