package com.nt.service;

import java.util.List;

import com.nt.bo.StudentBO;
import com.nt.dto.StudentDTO;

public interface StudentService {
	
	public List<StudentDTO> searchStudentByAddrs(String addrs);
	public StudentDTO  searchStudentByNo(int no);
	public String   modifyStudentByNo(StudentDTO dto);

}
