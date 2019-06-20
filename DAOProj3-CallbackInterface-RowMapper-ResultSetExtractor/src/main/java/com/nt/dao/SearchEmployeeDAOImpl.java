package com.nt.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.nt.bo.EmployeeBO;

public class SearchEmployeeDAOImpl implements SearchEmployeeDAO {
	private static final String GET_EMP_DETAILS_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_DETAILS_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";	 
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public EmployeeBO findEmployeeByNo(int no) {
		EmployeeBO bo=null;
		//execute Query
		bo=jt.queryForObject(GET_EMP_DETAILS_BY_NO,new EmployeeMapper(),no);

		return bo;
	}
	
	private class EmployeeMapper implements RowMapper<EmployeeBO>{

		@Override
		public EmployeeBO mapRow(ResultSet rs, int index) throws SQLException {
			EmployeeBO bo=null;
			//copy ResultSet obj record to Bo class object
			bo=new EmployeeBO();
			bo.setNo(rs.getInt(1));
			bo.setName(rs.getString(2));
			bo.setJob(rs.getString(3));
			bo.setSalary(rs.getInt(4));
			return bo;
		}
		
	}

	@Override
	public List<EmployeeBO> findEmployeesByDesg(String desg) {
        List<EmployeeBO> listBO=null;
        listBO=jt.query(GET_EMP_DETAILS_BY_DESG,new EmployeeExtractor(),desg);
		return listBO;
	}
	
	private class EmployeeExtractor implements ResultSetExtractor<List<EmployeeBO>>{

		@Override
		public List<EmployeeBO> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<EmployeeBO> listBO=null;
			EmployeeBO bo=null;
			listBO=new ArrayList();
			while(rs.next()){
				bo=new EmployeeBO();
				bo.setNo(rs.getInt(1));
				bo.setName(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setSalary(rs.getInt(4));
				listBO.add(bo);
			}
			return listBO;
		}//method
		
	}//inner class

}//class
