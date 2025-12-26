package com.examly.springapp.service;

import com.examly.springapp.model.Ticket;
import org.springframework.data.domain.Page;
import java.util.List;

public interface TicketService {
  Ticket createTicket(Ticket ticket);
  
  Page<Ticket> getAllTickets(int page, int size, String sortBy);
  
  Ticket getTicketById(Long id);
  Ticket updateTicket(Long id, Ticket ticket);
}
