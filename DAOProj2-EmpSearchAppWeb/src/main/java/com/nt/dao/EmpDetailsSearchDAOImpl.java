package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDetailsSearchDAOImpl implements EmpDetailsSearchDAO {
   
	private  JdbcTemplate  jt;
	
	 public void setJt(JdbcTemplate jt) {
			this.jt = jt;
		}


	@Override
	public List<Map<String, Object>> searchEmpDetailsByDesgs(String cond) {
		List<Map<String,Object>> listMap=null;
		listMap=jt.queryForList("SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB IN"+cond+" ORDER BY JOB",new Object[]{});
		return listMap;
	}

}
