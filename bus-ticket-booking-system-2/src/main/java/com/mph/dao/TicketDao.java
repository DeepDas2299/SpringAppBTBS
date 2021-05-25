package com.mph.dao;

import java.util.List;
import java.util.Set;

import com.mph.entity.Ticket;

/**
 * @author Farnaz S
 * @version 1.0
 */
public interface TicketDao {
	/**
	 * This method is used to get ticket by Id.
	 * 
	 * @param id This is the parameter to getTicketById method.
	 * @return Ticket This returns ticket of long data type .
	 */
	public Ticket getTicketById(long id);
	/**
	 * This method is used to get all Tickets.
	 * 
	 * @return List This returns a list of Ticket.
	 */
	public List<Ticket> getAllTickets();
	/**
	   * This method is used to add ticket.
	   * @param ticket  this is the parameter to addTicket method
	   * @return List This returns a list of ticket.
	   */
	public List<Ticket> addTicket(Ticket ticket);
	/**
	   * This method is used to update ticket.
	   * @param ticket  this is the parameter to updateTicket method
	   * @return List This returns a list of ticket.
	   */
	public List<Ticket> updateTicket(Ticket ticket);
	/**
	   * This method is used to delete ticket.
	   * @param ticket  this is the parameter to deleteTicket method
	   * @return List This returns a list of ticket.
	   */
	public List<Ticket> deleteTicket(Ticket ticket);
	/**
	 * This method is used to get ticket by journey Id.
	 * 
	 * @param id This is the parameter to getTicketByJourneyId  method.
	 * @return ticket This returns a list of ticket.
	 */

      public	List<Ticket> getTicketByJourneyId(long id);
      /**
  	 * This method is used to get ticket by journey Id.
  	 * 
  	 * @param journeyIdList This is the parameter to getTicketByJourneys  method.
  	 * @return ticket This returns a list of ticket.
  	 */
	public List<Ticket> getTicketByJourneys(Set<Long> journeyIdList);
	 /**
  	 * This method is used to get ticket by user Id.
  	 * 
  	 * @param id This is the parameter to getTicketsByUID  method.
  	 * @return ticket This returns a list of ticket.
  	 */
	public List<Ticket> getTicketsByUID(long id);
}
