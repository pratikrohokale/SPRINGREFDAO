package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.bo.ReservationDetailsBO;
import com.nt.dao.TicketReservationDAO;
import com.nt.dto.ReservationDetailsDTO;

@Service("reservationService")
public class TicketReservationServiceImpl implements TicketReservationService {
	@Autowired 
	private  TicketReservationDAO dao;
	
	@Override
	public String groupReseveration(List<ReservationDetailsDTO> listDTO) {
		List<ReservationDetailsBO> listBO=new ArrayList();
		int result[]=null;
		//Copy ListDTO to ListBO
		listDTO.forEach(dto->{
			ReservationDetailsBO bo=null;
			bo=new ReservationDetailsBO();
			BeanUtils.copyProperties(dto,bo);
			bo.setPid(dao.generatePassengerId());
			listBO.add(bo);
		});
		//use DAO
		result=dao.groupInsert(listBO);
		if(result!=null)
			return "Group Reservation is done";
		else
			return "Group Reservation is not done";
	}//method
}//class
