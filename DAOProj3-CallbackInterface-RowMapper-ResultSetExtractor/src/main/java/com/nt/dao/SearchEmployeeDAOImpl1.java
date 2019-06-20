package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.EmployeeBO;

public class SearchEmployeeDAOImpl1 implements SearchEmployeeDAO {
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";	 
	 private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	/*@Override
	public EmployeeBO findEmployeeByNo(int no) {
		EmployeeBO bo=null;
		//execute Query
		bo=jt.queryForObject(GET_EMP_DETAILS_BY_NO,
				             new RowMapper<EmployeeBO>(){
   	public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException {
   		EmployeeBO bo=null;
		//copy ResultSet obj record to Bo class object
		bo=new EmployeeBO();
		bo.setNo(rs.getInt(1));
		bo.setName(rs.getString(2));
		bo.setJob(rs.getString(3));
		bo.setSalary(rs.getInt(4));
		return bo;
			
		}},
          no);

		return bo;
	}*/
	
	
	@Override
	public EmployeeBO findEmployeeByNo(int no) {
		EmployeeBO bo=null;
		//execute Query
		bo=jt.queryForObject(GET_EMP_DETAILS_BY_NO,
                     (ResultSet rs, int index)->{ 
   		EmployeeBO ebo=null;
		//copy ResultSet obj record to Bo class object
		ebo=new EmployeeBO();
		ebo.setNo(rs.getInt(1));
		ebo.setName(rs.getString(2));
		ebo.setJob(rs.getString(3));
		ebo.setSalary(rs.getInt(4));
		return ebo;
		},
          no);

		return bo;
	}

	@Override
	public List<EmployeeBO> findEmployeesByDesg(String desg) {
		List<EmployeeBO> listBO=null;
		listBO=jt.query(GET_EMP_DETAILS_BY_DESG,rs->{
			List<EmployeeBO> listEmpBO=null;
			EmployeeBO bo=null;
			listEmpBO=new ArrayList();
			while(rs.next()){
				bo=new EmployeeBO();
				bo.setNo(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSalary(rs.getInt(4));
				listEmpBO.add(bo);
			}
			return listEmpBO;
			
		},
		desg		
		);
		return listBO;
	}//method

}//class
