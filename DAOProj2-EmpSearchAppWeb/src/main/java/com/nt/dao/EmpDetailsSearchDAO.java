package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface EmpDetailsSearchDAO {
	
	public List<Map<String,Object>> searchEmpDetailsByDesgs(String cond);

}
