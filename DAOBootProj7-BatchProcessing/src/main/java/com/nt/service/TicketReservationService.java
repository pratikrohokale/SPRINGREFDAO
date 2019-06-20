package com.nt.service;

import java.util.List;

import com.nt.dto.ReservationDetailsDTO;

public interface TicketReservationService {
	public String groupReseveration(List<ReservationDetailsDTO> listDTO);
}
