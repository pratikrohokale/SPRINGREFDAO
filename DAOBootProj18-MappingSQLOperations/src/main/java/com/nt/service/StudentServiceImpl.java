package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.StudentBO;
import com.nt.dao.StudentDAO;
import com.nt.dto.StudentDTO;

@Service("stService")
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDAO dao;


	@Override
	public List<StudentDTO> searchStudentByAddrs(String addrs) {
		List<StudentBO> listBO=null;
		List<StudentDTO> listDTO=new ArrayList();
		//use dAO
		listBO=dao.getStudentsByAddrs(addrs);
		//Copy listBO to listDTO
		listBO.forEach(bo->{
			StudentDTO dto=null;
			dto=new StudentDTO();
			BeanUtils.copyProperties(bo, dto);
			listDTO.add(dto);
		});
		
		return listDTO;
	}

	@Override
	public StudentDTO searchStudentByNo(int no) {
	     StudentBO bo=null;
	     StudentDTO dto=null;
		//use DAO
	     bo=dao.getStudentByNo(no);
	    //copy BO to DTO
	     dto=new StudentDTO();
	     BeanUtils.copyProperties(bo,dto);
		return dto; 

	}

	@Override
	public String modifyStudentByNo(StudentDTO dto) {
		StudentBO bo=null;
		int count=0;
		//Convert DTO to BO
		bo=new StudentBO();
		BeanUtils.copyProperties(dto,bo);
		//use DAO
		count=dao.updateStudentDetailsByNo(bo);
		if(count==0)
			return "Student Details are not updated";
		else
			return "Student Details are updated";
	}//method
}//class
