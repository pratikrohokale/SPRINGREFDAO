package com.nt.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;

import com.nt.bo.StudentBO;

public class StudentDAOImpl implements StudentDAO {
	private static final String GET_STUDETNS_BY_ADDRS = "SELECT SNO,SNAME,SADD FROM  STUDENT WHERE SADD=?";
	private static final String GET_STUDENT_BY_NO = "SELECT SNO,SNAME,SADD FROM STUDENT WHERE SNO=?";
	 private static final String  UPDATE_STUDENT_QUERY="UPDATE STUDENT SET  SNAME=? , SADD=? WHERE SNO=?";
	private StudentSelector stSelector;
	private StudentSelector1 stSelector1;
	private StudentUpdator stUpdator;

	public StudentDAOImpl(DataSource ds) {
		stSelector = new StudentSelector(ds, GET_STUDETNS_BY_ADDRS);
		stSelector1 = new StudentSelector1(ds, GET_STUDENT_BY_NO);
		stUpdator=new StudentUpdator(ds,UPDATE_STUDENT_QUERY);
	}

	public List<StudentBO> getStudentsByAddrs(String addrs) {
		List<StudentBO> listBO = null;
		listBO = stSelector.execute(addrs);
		return listBO;
	}

	public StudentBO getStudentByNo(int no) {
		StudentBO bo = null;
		bo = stSelector1.findObject((long) no);
		return bo;
	}
	
	@Override
	public int updateStudentDetailsByNo(StudentBO bo) {
		int count=0;
		count=stUpdator.update(bo.getSname(),bo.getSadd(),bo.getSno());
		return count;
	}
	

	// inner and sub classes
	public class StudentSelector extends MappingSqlQuery<StudentBO> {

		public StudentSelector(DataSource ds, String query) {
			super(ds, query);
			super.declareParameter(new SqlParameter(Types.VARCHAR));
			super.compile();
		}


		public StudentBO mapRow(ResultSet rs, int index) throws SQLException {
			StudentBO bo = null;
			bo = new StudentBO();
			bo.setSno(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSadd(rs.getString(3));
			return bo;
		}

	}// inner class

	private class StudentSelector1 extends MappingSqlQuery<StudentBO> {

		private StudentSelector1(DataSource ds, String query) {
			super(ds, query);
			super.declareParameter(new SqlParameter(Types.INTEGER));
			super.compile();
		}

		public StudentBO mapRow(ResultSet rs, int index) throws SQLException {
			StudentBO bo = null;
			bo = new StudentBO();
			bo.setSno(rs.getInt(1));
			bo.setSname(rs.getString(2));
			bo.setSadd(rs.getString(3));
			return bo;
		}

	}//inner class
	
	private class StudentUpdator  extends  SqlUpdate{
        public  StudentUpdator(DataSource ds, String query){
              super(ds,query);
             super.declareParameter(new SqlParameter(Types.VARCHAR));
             super.declareParameter(new SqlParameter(Types.VARCHAR));
             super.declareParameter(new SqlParameter(Types.INTEGER));
            super.compile();
         }

     }//inner class

	

}
