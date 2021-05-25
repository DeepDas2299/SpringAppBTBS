package com.mph.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Bus;
import com.mph.entity.JourneyDetails;
import com.mph.entity.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Ticket getTicketById(long id) {
		return (Ticket) getSession().createQuery("from Ticket t where ticketId=:id").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public List<Ticket> getAllTickets() {
		return getSession().createQuery("from Ticket t").list();
	}

	@Override
	public List<Ticket> addTicket(Ticket ticket) {
		getSession().save(ticket);
		return getAllTickets();
	}

	@Override
	public List<Ticket> updateTicket(Ticket ticket) {
		getSession().saveOrUpdate(ticket);
		return getAllTickets();
	}

	@Override
	public List<Ticket> deleteTicket(Ticket ticket) {
		getSession().evict(ticket);
		getSession().delete(ticket);
		return getAllTickets();
	}

	@Override
	public List<Ticket> getTicketByJourneyId(long id) {
		return getSession().createCriteria(Ticket.class).add(Restrictions.eq("journey.journeyID", id)).list();

	}

	@Override
	public List<Ticket> getTicketByJourneys(Set<Long> journeyIdSet){
		return getSession().createCriteria(Ticket.class).add(Restrictions.in("journey.journeyID", journeyIdSet)).list();


	}
	@Override
	public List<Ticket> getTicketsByUID(long id)
	{
		return getSession().createQuery("from Ticket where user.uid = :id").setParameter("id", id).list();
	}
	
}
