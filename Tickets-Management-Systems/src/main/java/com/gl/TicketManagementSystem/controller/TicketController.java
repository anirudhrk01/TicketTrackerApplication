package com.gl.TicketManagementSystem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.TicketManagementSystem.entity.Ticket;
import com.gl.TicketManagementSystem.service.TicketService;

@Controller
public class TicketController {

	private TicketService ticketService;

	public TicketController(TicketService ticketService) {
		super();
		this.ticketService = ticketService;
	}

	@GetMapping("/ticket")
	public String listTicket(Model model) {
		model.addAttribute("ticket", ticketService.getAllTicket());
		return "ticket";
	}

	@GetMapping("/ticket/new")
	public String createTicketForm(Model model) {

		Ticket ticket = new Ticket();
		model.addAttribute("ticket", ticket);
		return "create_ticket";

	}

	@PostMapping("/ticket")
	public String saveTicket(@ModelAttribute("ticket") Ticket ticket) {
		ticketService.saveTicket(ticket);
		return "redirect:/ticket";
	}

	@GetMapping("/ticket/edit/{id}")
	public String editTicketForm(@PathVariable Long id, Model model) {
		model.addAttribute("ticket", ticketService.getTicketById(id));
		return "edit_ticket";
	}

	@PostMapping("/ticket/{id}")
	public String updateTicket(@PathVariable Long id, @ModelAttribute("ticket") Ticket ticket, Model model) {

		Ticket existingTicket = ticketService.getTicketById(id);
		existingTicket.setId(id);
		existingTicket.setTickettitle(ticket.getTickettitle());
		existingTicket.setTicketshortdescription(ticket.getTicketshortdescription());
		existingTicket.setTicketcreatedon(ticket.getTicketcreatedon());

		ticketService.updateTicket(existingTicket);
		return "redirect:/ticket";
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Ticket>> searchTicket(@RequestParam("query") String query){
		return ResponseEntity.ok(ticketService.searchTicket(query));
	}

	@GetMapping("/ticket/{id}")
	public String deleteTicket(@PathVariable Long id) {
		ticketService.deleteTicketById(id);
		return "redirect:/ticket";
	}

}