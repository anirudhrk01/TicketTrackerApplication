package com.gl.TicketManagementSystem.service;

import java.util.List;

import com.gl.TicketManagementSystem.entity.Ticket;


public interface TicketService {

	List<Ticket> getAllTicket();

	void deleteTicketById(Long id);

	Ticket saveTicket(Ticket ticket);

	Ticket getTicketById(Long id);

	Ticket updateTicket(Ticket existingTicket);
	
	List<Ticket> searchTicket(String query);
	

}