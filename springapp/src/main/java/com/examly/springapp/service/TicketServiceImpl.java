package com.examly.springapp.service;

import com.examly.springapp.model.Ticket;
import com.examly.springapp.repository.TicketRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {

  @Autowired
  private TicketRepo ticketRepo;

  @Override
  public Ticket createTicket(Ticket ticket) {
    return ticketRepo.save(ticket);
  }

  @Override
  public Page<Ticket> getAllTickets(int page, int size, String sortBy) {
    Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
    return ticketRepo.findAll(pageable);
  }

  @Override
  public Ticket getTicketById(Long id) {
    return ticketRepo.findById(id).orElse(null);
  }

  @Override
  public Ticket updateTicket(Long id, Ticket ticket) {
    Ticket existingTicket = ticketRepo.findById(id).orElse(null);
    if (existingTicket != null) {
      existingTicket.setSubject(ticket.getSubject());
      existingTicket.setDescription(ticket.getDescription());
      existingTicket.setStatus(ticket.getStatus());
      existingTicket.setAssignedTo(ticket.getAssignedTo());
      return ticketRepo.save(existingTicket);
    }
    return null;
  }
}
