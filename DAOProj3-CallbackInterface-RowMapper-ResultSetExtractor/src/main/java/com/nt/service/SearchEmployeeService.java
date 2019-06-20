package com.nt.service;

import java.util.List;

import com.nt.dto.EmployeeDTO;

public interface SearchEmployeeService {
   public EmployeeDTO  searchEmployeeByNo(int no);
   public List<EmployeeDTO> searchEmployeeByDesg(String desg);
}
