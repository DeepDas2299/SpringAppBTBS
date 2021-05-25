package com.mph.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.JourneyDetailsDao;
import com.mph.dao.TicketDao;
import com.mph.dao.UserDao;
import com.mph.entity.JourneyDetails;
import com.mph.entity.Ticket;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class JourneyDetailsServiceImpl implements JourneyDetailsService {

	@Autowired
	JourneyDetailsDao journeyDetailsDao;
	@Autowired
	UserDao userDao;
	@Autowired
	TicketDao ticketDao;
	
	@Override
	public JourneyDetails getJourneyDetailsById(long id) {
		return journeyDetailsDao.getJourneyDetailsById(id);
	}

	@Override
	public List<JourneyDetails> getAllJourneyDetails() {
		return journeyDetailsDao.getAllJourneyDetails();
	}

	@Override
	public List<JourneyDetails> addJourneyDetails(JourneyDetails journeyDetails) {
		if (getJourneyDetailsById(journeyDetails.getJourneyID()) != null)
			throw new DataAlreadyExistsException("JourneyDetails with ID : " + journeyDetails.getJourneyID() + " already exists");
		else {
			return journeyDetailsDao.addJourneyDetails(journeyDetails);
		}
	}

	@Override
	public List<JourneyDetails> updateJourneyDetails(JourneyDetails journeyDetails) {
		if (getJourneyDetailsById(journeyDetails.getJourneyID()) == null)
			throw new DataNotFoundException("JourneyDetails with ID : " + journeyDetails.getJourneyID() + " not found" );
		else {
			return journeyDetailsDao.updateJourneyDetails(journeyDetails);
		}
	}

	@Override
	public List<JourneyDetails> deleteJourneyDetails(long id) {
		JourneyDetails journeyDetails = getJourneyDetailsById(id);
		if (journeyDetails == null)
			throw new DataNotFoundException("JourneyDetails with ID : " + id + " not found" );
		else {
			Set<Ticket> tickets = new HashSet<Ticket>();
			ticketDao.getTicketByJourneyId(id).forEach(ticket -> {if(ticket != null) {
				tickets.add(ticket);
			}
			});
			tickets.forEach(ticket -> ticketDao.deleteTicket(ticket));
			return journeyDetailsDao.deleteJourneyDetails(journeyDetails);
		}
	}

	@Override
	public List<JourneyDetails> getJourneyBySearch(String source, String dest, String date) {
		
		return journeyDetailsDao.getJourneyBySearch(source, dest, date);
	}

}
