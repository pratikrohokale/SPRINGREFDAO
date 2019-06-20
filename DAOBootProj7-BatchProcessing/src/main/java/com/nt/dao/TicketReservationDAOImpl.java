package com.nt.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nt.bo.ReservationDetailsBO;

@Repository("reservationDAO")
public class TicketReservationDAOImpl implements TicketReservationDAO {
	private static final String INSERT_RESERVATION_DETAILS="INSERT INTO RAIL_TICKET_RESERVATION VALUES(?,?,?,?,?)";
	private static  final String GET_PID_QUERY="SELECT PID_SEQ1.NEXTVAL FROM DUAL"; 
    @Autowired
	private JdbcTemplate jt;

	
	
	@Override
	public int generatePassengerId() {
		System.out.println("DAO-->DataSource:::"+jt.getDataSource().getClass());
	   int pid=0;
	   pid=jt.queryForObject(GET_PID_QUERY, Integer.class);
		return pid;
	}
	
	

	@Override
	public int[] groupInsert(List<ReservationDetailsBO> listBO) {
		int result[]=null;
		result=jt.batchUpdate(INSERT_RESERVATION_DETAILS,new ReservationBatchProcessing(listBO));
		return result;
	}
	
	private class ReservationBatchProcessing implements BatchPreparedStatementSetter{
          private List<ReservationDetailsBO> listBO;
		 public  ReservationBatchProcessing(List<ReservationDetailsBO> listBO) {
		   this.listBO=listBO;
		}
		@Override
		public int getBatchSize() {
			System.out.println("getBatchSize()");
			return listBO.size();
		}

		//if getBatchSize() method returns 5 then setValues(-,-) method executes for
		//5 times
		@Override
		public void setValues(PreparedStatement ps, int i) throws SQLException {
			System.out.println("setValues(-,-)");
			//assign each set of query param values to batch
			ps.setInt(1,listBO.get(i).getPid());
			ps.setString(2, listBO.get(i).getName());
			ps.setInt(3,listBO.get(i).getAge());
			ps.setString(4,listBO.get(i).getBoardingFrom());
			ps.setString(5,listBO.get(i).getDestination());
		}//method
		
	}//inner class

}//outer class
