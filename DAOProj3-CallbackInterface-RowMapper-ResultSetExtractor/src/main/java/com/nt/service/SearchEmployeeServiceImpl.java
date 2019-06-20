package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.nt.bo.EmployeeBO;
import com.nt.dao.SearchEmployeeDAO;
import com.nt.dto.EmployeeDTO;

public class SearchEmployeeServiceImpl implements SearchEmployeeService {
    private SearchEmployeeDAO dao;
	
    public void setDao(SearchEmployeeDAO dao) {
		this.dao = dao;
	}

	@Override
	public EmployeeDTO searchEmployeeByNo(int no) {
		EmployeeBO bo=null;
		EmployeeDTO dto=null;
		//use DAO
		bo=dao.findEmployeeByNo(no);
		//Copy BO to DTO
		dto=new EmployeeDTO();
		BeanUtils.copyProperties(bo,dto);
		
		return dto;
	}

	@Override
	public List<EmployeeDTO> searchEmployeeByDesg(String desg) {
		 List<EmployeeBO> listBO=null;
		 List<EmployeeDTO> listDTO=new ArrayList();
		 
		  //use DAO
		 listBO=dao.findEmployeesByDesg(desg);
		 //copy listBO to listDTO
		 listBO.forEach(bo->{
		   EmployeeDTO dto=null;
		   dto=new EmployeeDTO();
		   BeanUtils.copyProperties(bo,dto);
    	    listDTO.add(dto); 
		 });
		return listDTO;
	}//method
}//class
