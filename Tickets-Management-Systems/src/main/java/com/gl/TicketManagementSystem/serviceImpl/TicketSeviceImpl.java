package com.gl.TicketManagementSystem.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


import com.gl.TicketManagementSystem.entity.Ticket;
import com.gl.TicketManagementSystem.repository.TicketRepository;
import com.gl.TicketManagementSystem.service.TicketService;

@Service
public class TicketSeviceImpl implements TicketService {

	private TicketRepository ticketRepository;

	public TicketSeviceImpl(TicketRepository ticketRepository) {
		super();
		this.ticketRepository = ticketRepository;
	}

	@Override
	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public Ticket getTicketById(Long id) {
		return ticketRepository.findById(id).get();
	}

	@Override
	public Ticket updateTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public void deleteTicketById(Long id) {
		ticketRepository.deleteById(id);
   }
	
	@Override
	public List<Ticket> searchTicket(String query) {
		List<Ticket> ticket= ticketRepository.searchTicket(query);
		return ticket;
	}

	
}