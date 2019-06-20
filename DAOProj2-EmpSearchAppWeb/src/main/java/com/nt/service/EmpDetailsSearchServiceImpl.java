package com.nt.service;

import java.util.List;
import java.util.Map;

import com.nt.dao.EmpDetailsSearchDAO;

public class EmpDetailsSearchServiceImpl implements EmpDetailsSearchService {
  
	private EmpDetailsSearchDAO dao;
	
	  public void setDao(EmpDetailsSearchDAO dao) {
			this.dao = dao;
		}

    
	@Override
	public List<Map<String, Object>> findEmpDetailsByDesg(String[] desgs) {
		List<Map<String,Object>> listMap=null;
		StringBuffer cond=null;
		//frame condition with array of desgs ('CLERK','MANAGER')
		cond=new StringBuffer("(");
		for(int i=0;i<desgs.length;++i){
			if(i==desgs.length-1)
				cond.append("'"+desgs[i]+"')");
			else
				cond.append("'"+desgs[i]+"',");
		}
		//use DAO
		listMap=dao.searchEmpDetailsByDesgs(cond.toString());
		return listMap;
	}//method
}//class
