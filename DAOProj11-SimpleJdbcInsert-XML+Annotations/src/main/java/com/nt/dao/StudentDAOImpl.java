package com.nt.dao;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.inject.Named;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.nt.bo.StudentBO;

@Named("stDAO")
public class StudentDAOImpl implements StudentDAO {
	private static final String TABLE_NAME="STUDENT";
	@Resource
	private SimpleJdbcInsert sji;

	/*@Override
	public int insert(StudentBO bo) {
		Map<String,Object> map=null;
		int count=0;
		//set Col names and values in a Map object
		map=new HashMap();
		map.put("SNO",bo.getSno());
		map.put("SNAME", bo.getSname());
		map.put("SADD",bo.getSadd());
		//set db table name 
		sji.setTableName(TABLE_NAME);
		//make to generate query dynamically for insert operation
		count=sji.execute(map);
		return count;
	}
*/
	
	@Override
	public int insert(StudentBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count=0;
		//set Col names and values in a Map object
		bpsps=new BeanPropertySqlParameterSource(bo);
		//set db table name 
		sji.setTableName(TABLE_NAME);
		//make to generate query dynamically for insert operation
		count=sji.execute(bpsps);
		return count;
	}

}
