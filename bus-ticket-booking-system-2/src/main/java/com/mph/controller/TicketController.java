package com.mph.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Ticket;
import com.mph.service.TicketService;

@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},allowedHeaders = "*")
@RestController
@RequestMapping("/ticket")
/**
 * @author Deep Das
 * @version 1.0
 */
public class TicketController {

	@Autowired
	TicketService ticketService;
	private static final Logger logger = Logger.getLogger("TicketController.class");
	/**
	 * This method is used to get all Tickets.
	 * 
	 * @return ResponseEntity This returns a list of Tickets.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Ticket>> getAllTicket() {
		logger.info("Getting All Tickets");
		List<Ticket> ticketList = ticketService.getAllTickets();
		if (ticketList == null)
			return new ResponseEntity<List<Ticket>>(HttpStatus.NO_CONTENT);
		System.out.println(ticketList);
		return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);

	}
	/**
	 * This method is used to get the Tickets by Id.
	 * 
	 * @param id This parameter is used to get the Tickets by id.
	 * @return ResponseEntity This returns a Ticket with the given by id.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Ticket> getTicketById(@PathVariable long id) {
		logger.info("Getting Ticket by ID : " + id);
		Ticket ticket = ticketService.getTicketById(id);
		System.out.println(ticket);
		if (ticket == null)
			return new ResponseEntity<Ticket>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Ticket>(ticket, HttpStatus.OK);

	}
	/**
	 * This method is used to add the Tickets.
	 * @param ticket This is passed down as the request body
	 * @return This returns a ResponseEntity  with a list of Tickets.
	 */
	@PostMapping("/add")
	public ResponseEntity<List<Ticket>> addTicket(@Valid @RequestBody Ticket ticket) {
		logger.info("Ticket booked by : " + ticket.getUser().getUid() + ", at : " + ticket.getBookingTime());
		List<Ticket> ticketList = ticketService.addTicket(ticket);
		if (ticketList == null)
			return new ResponseEntity<List<Ticket>>(HttpStatus.NO_CONTENT);
		System.out.println(ticketList);
		return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);

	}
	/**
	 * This method is used to delete the ticket.
	 * 
	 * @param id This parameter is used to delete the ticket by id.
	 * @return ResponseEntity This returns a list of tickets.
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Ticket>> deleteTicketById(@PathVariable long id) {
		logger.info("Removing Ticket : " + id);
		List<Ticket> ticketList = ticketService.deleteTicket(id);
		if (ticketList == null)
			return new ResponseEntity<List<Ticket>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);

	}
	/**
	 * This method is used to get the Tickets by user Id.
	 * 
	 * @param id This parameter is used to get the Tickets of the user by id.
	 * @return ResponseEntity This returns a Ticket of the user with the given by id.
	 */
	@GetMapping("/uid/{id}")
	public ResponseEntity<List<Ticket>> getTicketsByUID(@PathVariable long id) {
		logger.info("Getting Tickets for user : " + id);
		List<Ticket> ticketList = ticketService.getTicketsByUID(id);
		if (ticketList == null)
			return new ResponseEntity<List<Ticket>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Ticket>>(ticketList, HttpStatus.OK);

	}
}