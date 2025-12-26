package com.examly.springapp.controller;

import com.examly.springapp.model.Ticket;
import com.examly.springapp.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page; // Import
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

  @Autowired
  private TicketService ticketService;

  @PostMapping
  public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
    Ticket createdTicket = ticketService.createTicket(ticket);
    return new ResponseEntity<>(createdTicket, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<Page<Ticket>> getAllTickets(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(defaultValue = "ticketId") String sortBy) {
    
    Page<Ticket> tickets = ticketService.getAllTickets(page, size, sortBy);
    return new ResponseEntity<>(tickets, HttpStatus.OK);
  }
@GetMapping("/page/{page}/{size}")
public ResponseEntity<Page<Ticket>> getTicketsWithPagination(
        @PathVariable int page,
        @PathVariable int size) {

    Page<Ticket> tickets = ticketService.getAllTickets(page, size, "ticketId");
    return new ResponseEntity<>(tickets, HttpStatus.OK);
}

  @GetMapping("/{id}")
  public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
    Ticket ticket = ticketService.getTicketById(id);
    return new ResponseEntity<>(ticket, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Ticket> updateTicket(@PathVariable Long id, @RequestBody Ticket ticket) {
    Ticket updatedTicket = ticketService.updateTicket(id, ticket);
    return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
  }
}
