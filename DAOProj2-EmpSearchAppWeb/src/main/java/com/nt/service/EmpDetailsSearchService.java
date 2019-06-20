package com.nt.service;

import java.util.List;
import java.util.Map;

public interface EmpDetailsSearchService {
	public List<Map<String,Object>> findEmpDetailsByDesg(String desgs[]);

}
