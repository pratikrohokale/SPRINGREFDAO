package com.nt.dao;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;

@Repository("empDAO")
public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=:id";
	private static final String GET_EMP_DETAILS_BY_DESGANDDEPT="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=:desg AND DEPTNO=:dno";
	private static final  String INSERT_EMP_DETAILS="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(:no,:ename,:job,:salary)";
   @Autowired
	private NamedParameterJdbcTemplate npjt;


	/*@Override
	public EmployeeBO getEmployeeByNo(int no) {
		Map<String,Object> params=null;
		EmployeeBO bo=null;
		params=new HashMap();
		params.put("id",no);
		
		//execute Query
		bo=npjt.queryForObject(GET_EMP_DETAILS_BY_NO,
				                   params,
				                   new RowMapper<EmployeeBO>(){
									@Override
					public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException {
								 EmployeeBO bo=null;
								//copy ResultSet record to BO
								 bo=new EmployeeBO();
								 bo.setNo(rs.getInt(1));
								 bo.setEname(rs.getString(2));
								 bo.setJob(rs.getString(3));
								 bo.setSalary(rs.getInt(4));
								return bo;		
					}//method
		});
		
		return bo;
	}//method
*/
	
	@Override
	public EmployeeBO getEmployeeByNo(int no) {
		Map<String,Object> params=null;
		EmployeeBO bo=null;
		params=new HashMap();
		params.put("id",no);
		
		//execute Query
		bo=npjt.queryForObject(GET_EMP_DETAILS_BY_NO,
				                   params,
				                    (rs,index)->{
								 EmployeeBO ebo=null;
								//copy ResultSet record to BO
								 ebo=new EmployeeBO();
								 ebo.setNo(rs.getInt(1));
								 ebo.setEname(rs.getString(2));
								 ebo.setJob(rs.getString(3));
								 ebo.setSalary(rs.getInt(4));
								return ebo;		
					}//method
		);
		
		return bo;
	}//method
	
	@Override
	public List<EmployeeBO> getEmployeesByDesgAndDeptNo(String desg, int deptno) {
		List<EmployeeBO> listBO=null;
		MapSqlParameterSource params=null;
		//prepare params
		params=new MapSqlParameterSource();
		params.addValue("desg",desg);
		params.addValue("dno",deptno);
		
		
		listBO=npjt.query(GET_EMP_DETAILS_BY_DESGANDDEPT,
				          params,
				          (rs)->{
				         List<EmployeeBO> listEBO=null;	  
				         listEBO=new ArrayList();
				          while(rs.next()){
				        	EmployeeBO bo=null;
				        	bo=new EmployeeBO();
				        	bo.setNo(rs.getInt(1));
				        	bo.setEname(rs.getString(2));
				        	bo.setJob(rs.getString(3));
				        	bo.setSalary(rs.getInt(4));
				        	listEBO.add(bo);
				          }
				          return listEBO;
				          });
		return listBO;
	}//method
	
	@Override
	public int insert(EmployeeBO bo) {
		BeanPropertySqlParameterSource bpsps=null;
		int count=0;
		//prpeare params
		bpsps=new BeanPropertySqlParameterSource(bo);
		count=npjt.update(INSERT_EMP_DETAILS, bpsps);
		return count;
	}
	
}//class
