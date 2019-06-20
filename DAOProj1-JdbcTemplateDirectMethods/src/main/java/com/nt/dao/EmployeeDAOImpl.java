package com.nt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static final String GET_EMP_COUNT = "SELECT COUNT(*) FROM EMP";
	private static final String GET_EMP_BY_NO="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	private static final String GET_EMP_BY_DESG="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE JOB=?";
	private static final String EMP_INSERT_QUERY="INSERT INTO EMP(EMPNO,ENAME,JOB,SAL) VALUES(?,?,?,?)";
	private static final String GET_EMP_SALARY_BY_NO="SELECT SAL FROM EMP WHERE EMPNO=?";
	private static final String UPDATE_EMP_BY_NO="UPDATE EMP SET SAL=? WHERE EMPNO=?";
	private static final String DELETE_EMP_BY_NO="DELETE FROM EMP WHERE EMPNO=?";
	
	private JdbcTemplate jt;

	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int getEmpsCount() {
		int count = 0;
		// count=jt.queryForObject(GET_EMP_COUNT,Integer.class);
		count = jt.queryForObject(GET_EMP_COUNT, Integer.class, new Object[] {});
		return count;

	}

	@Override
	public Map<String, Object> getEmpByNumber(int eno) {
		Map<String,Object> map=null;
		map=jt.queryForMap(GET_EMP_BY_NO,eno);
		return map;
	}
	
	@Override
	public List<Map<String, Object>> getEmpsByDesg(String desg) {
		List<Map<String,Object>> list=null;
		list=jt.queryForList(GET_EMP_BY_DESG,desg);
		return list;
	}
	
	@Override
	public int insert(int eno, String name, String desg, float salary) {
		int count=0;
		// TODO Auto-generated method stub
		count=jt.update(EMP_INSERT_QUERY, eno,name,desg,salary);
		return count;
	}
	
	@Override
	public float getEmpSalaryByNo(int no) {
		float salary=0.0f;
		salary=jt.queryForObject(GET_EMP_SALARY_BY_NO, Float.class,no);
		return salary;
	}
	
	@Override
	public int update(int eno, float newSalary) {
		int count=0;
		count=jt.update(UPDATE_EMP_BY_NO,newSalary,eno);
		return count;
	}
	
	@Override
	public int delete(int eno) {
		int count=0;
		count=jt.update(DELETE_EMP_BY_NO,eno);
		return count;
	}
	

}
