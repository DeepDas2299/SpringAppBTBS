package com.mph.service;

import java.util.List;

import com.mph.entity.Ticket;

/**
 * @author Deep Das
 * @version 1.0
 */
public interface TicketService {
	/**
	 * This method is used to get Ticket By Id.
	 * @param id This is the parameter to getTicketById method.
	 * @return Ticket This returns a list of tickets.
	 */
	public Ticket getTicketById(long id);
	/**
	 * This method is used to get all Tickets.
	 * @return List This returns a list of Tickets.
	 */
	public List<Ticket> getAllTickets();
	/**
	   * This method is used to add tickets.
	   * @param ticket this is the parameter to addTicket method
	   * @return List This returns a list of Tickets.
	   */
	public List<Ticket> addTicket(Ticket ticket);
	/**
	   * This method is used to update tickets.
	   * @param ticket this is the parameter to updateTicket method
	   * @return List This returns a list of Tickets.
	   */
	public List<Ticket> updateTicket(Ticket ticket);
	/**
	   * This method is used to delete tickets.
	   * @param id this is the parameter to deleteTicket method
	   * @return List This returns a list of Tickets.
	   */
	public List<Ticket> deleteTicket(long id);
	/**
	 * This method is used to get Tickets By UID.
	 * @param id This is the parameter to getTicketsByUID method.
	 * @return List This returns a list of tickets.
	 */
	public List<Ticket> getTicketsByUID(long id);
}