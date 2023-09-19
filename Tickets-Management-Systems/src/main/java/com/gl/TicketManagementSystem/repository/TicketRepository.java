package com.gl.TicketManagementSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.TicketManagementSystem.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
	
	@Query("select t from Ticket t where " + "t.tickettitle like concat('%',:query,'%')")
	List<Ticket> searchTicket(String query);
}


