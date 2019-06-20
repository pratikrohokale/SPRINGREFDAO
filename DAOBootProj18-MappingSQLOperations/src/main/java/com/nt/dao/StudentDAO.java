package com.nt.dao;

import java.util.List;

import com.nt.bo.StudentBO;

public interface StudentDAO {
	
	public  List<StudentBO> getStudentsByAddrs(String addrs);
	public StudentBO  getStudentByNo(int no);
	public int updateStudentDetailsByNo(StudentBO bo);

}
