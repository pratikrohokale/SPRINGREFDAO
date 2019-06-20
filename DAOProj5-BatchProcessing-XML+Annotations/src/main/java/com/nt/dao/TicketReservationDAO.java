package com.nt.dao;

import java.util.List;

import com.nt.bo.ReservationDetailsBO;

public interface TicketReservationDAO {
	
	public int[]  groupInsert(List<ReservationDetailsBO> listBO);
    public  int   generatePassengerId();
}
