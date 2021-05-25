package com.mph.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.BusDao;
import com.mph.dao.DiscountDao;
import com.mph.dao.JourneyDetailsDao;
import com.mph.dao.TicketDao;
import com.mph.dao.UserDao;
import com.mph.entity.Bus;
import com.mph.entity.Discount;
import com.mph.entity.JourneyDetails;
import com.mph.entity.Ticket;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;


@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class BusServiceImpl implements BusService {

	@Autowired
	BusDao busDao;
	@Autowired
	UserDao userDao;
	@Autowired
	JourneyDetailsDao journeyDao;
	@Autowired
	TicketDao ticketDao;
	@Autowired
	DiscountDao discountDao;
	

	@Override
	public List<Bus> getAllBuses() {
		return busDao.getAllBuses();
	}


	@Override
	public Bus getBusById(long id) {

		return busDao.getBusById(id);
	}

	@Override
	public List<Bus> addBus(Bus bus) {
		if (getBusById(bus.getBusId()) != null)
			throw new DataAlreadyExistsException("Bus with ID : " + bus.getBusId() + " already exists");
		else {
			bus.getSeats().forEach(seat -> seat.setBus(bus));
			return busDao.addBus(bus);
		}
	}

	@Override
	public List<Bus> updateBus(Bus bus) {
		if (getBusById(bus.getBusId()) == null)
			throw new DataNotFoundException("Bus with ID : " + bus.getBusId() + " not found");
		else {
			bus.getSeats().forEach(seat -> seat.setBus(bus));
			return busDao.updateBus(bus);
		}
	}
	@Override
	public List<Bus> deleteBus(long id) {
		Bus bus = getBusById(id);
		if (bus == null)
			throw new DataNotFoundException("Bus with ID : " + id + " not found");
		else {
			List<JourneyDetails> journeyList = journeyDao.getJourneyByBusId(id);
			if (!journeyList.isEmpty()) {
				Set<Ticket> tickets = new HashSet<Ticket>();

				Set<Long> journeyIdSet = journeyList.stream().map(JourneyDetails::getJourneyID)
						.collect(Collectors.toSet());
				ticketDao.getTicketByJourneys(journeyIdSet).forEach(ticket -> {
					if (ticket != null) {
						tickets.add(ticket);
					}
				});
				tickets.forEach(ticket -> ticketDao.deleteTicket(ticket));
				Set<JourneyDetails> journeySet = new HashSet<JourneyDetails>();
				journeyList.forEach(journey -> {
					journeySet.add(journey);
				});
				journeySet.forEach(journey -> journeyDao.deleteJourneyDetails(journey));
			}
			List<Discount> discountList = discountDao.getDiscountByBusId(id);
			discountList.forEach(discount -> discountDao.deleteDiscount(discount));

			return busDao.deleteBus(bus);
		}

	}

}
