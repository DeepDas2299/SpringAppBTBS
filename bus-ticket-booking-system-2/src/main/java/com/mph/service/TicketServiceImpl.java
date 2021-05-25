package com.mph.service;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.BusDao;
import com.mph.dao.JourneyDetailsDao;
import com.mph.dao.TicketDao;
import com.mph.dao.UserDao;
import com.mph.entity.JourneyDetails;
import com.mph.entity.Ticket;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketDao ticketDao;
	@Autowired
	JourneyDetailsDao journeyDetailsDao;
	@Autowired
	UserDao userDao;
	@Autowired
	BusDao busDao;
	@Autowired
	BusService busService;

	@Override
	public Ticket getTicketById(long id) {
		return ticketDao.getTicketById(id);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return ticketDao.getAllTickets();
	}

	@Override
	public List<Ticket> addTicket(Ticket ticket) {
		if (getTicketById(ticket.getTicketId()) != null)
			throw new DataAlreadyExistsException("Ticket with ID : " + ticket.getTicketId() + " already exists");
		else {
			JourneyDetails journeyDetails = journeyDetailsDao.getJourneyDetailsById(ticket.getJourney().getJourneyID());

			if (journeyDetails != null) {
				int availableSeats = journeyDetails.getAvailableSeats();
				int bookedSeats = ticket.getSeatsBooked();

				if (availableSeats - bookedSeats >= 0) {
					Set<Long> requestedSeats = ticket.getBookedSeats();
					if (Collections.disjoint(requestedSeats, journeyDetails.getBookedSeats()))
						journeyDetails.getBookedSeats().addAll(requestedSeats);
					else
						return null;

					journeyDetails.setAvailableSeats(availableSeats - bookedSeats);
					journeyDetailsDao.updateJourneyDetails(journeyDetails);
					ticket.setUser(userDao.getUserbyId(ticket.getUser().getUid()));
					ticket.setJourney(journeyDetails);

					List<Ticket> t = ticketDao.addTicket(ticket);
					return t;
				}
			}
			return null;
		}
	}

	@Override
	public List<Ticket> updateTicket(Ticket ticket) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ticket> deleteTicket(long id) {
		Ticket ticket = getTicketById(id);
		if (ticket == null)
			throw new DataNotFoundException("Ticker with ID : " + id + " not found");
		JourneyDetails journeyDetails = journeyDetailsDao.getJourneyDetailsById(ticket.getJourney().getJourneyID());
		journeyDetails.getBookedSeats().removeAll(ticket.getBookedSeats());
		journeyDetails.setAvailableSeats(journeyDetails.getAvailableSeats() + ticket.getSeatsBooked());
		journeyDetailsDao.updateJourneyDetails(journeyDetails);

		return ticketDao.deleteTicket(ticket);
	}

	@Override
	public List<Ticket> getTicketsByUID(long id) {
		return ticketDao.getTicketsByUID(id);
	}

}
