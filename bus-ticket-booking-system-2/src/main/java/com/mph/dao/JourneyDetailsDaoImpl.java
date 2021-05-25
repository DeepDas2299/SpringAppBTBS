package com.mph.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.JourneyDetails;

@Repository
public class JourneyDetailsDaoImpl implements JourneyDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public JourneyDetails getJourneyDetailsById(long id) {
		return getSession().get(JourneyDetails.class, id);
	}

	@Override
	public List<JourneyDetails> getAllJourneyDetails() {
		return getSession().createQuery("select jd from JourneyDetails jd").list();
	}

	@Override
	public List<JourneyDetails> addJourneyDetails(JourneyDetails journeyDetails) {
		getSession().save(journeyDetails);
		return getAllJourneyDetails();
	}

	@Override
	public List<JourneyDetails> updateJourneyDetails(JourneyDetails journeyDetails) {
		getSession().merge(journeyDetails);
		return getAllJourneyDetails();
	}

	@Override
	public List<JourneyDetails> deleteJourneyDetails(JourneyDetails journeyDetails) {
		getSession().evict(journeyDetails);
		getSession().delete(journeyDetails);
		//getSession().clear();
		return getAllJourneyDetails();
	}

	@Override
	public List<JourneyDetails> getJourneyByBusId(long id) {
		return getSession().createCriteria(JourneyDetails.class).add(Restrictions.eq("bus.busId", id)).list();

	}

	@Override
	public List<JourneyDetails> getJourneyBySearch(String source, String dest, String date) {
		return getSession().createQuery("from JourneyDetails where source = '"+ source + "'and dest='" + dest + "'and to_char(journeyDate,'yyyy-MM-DD') = '"+date + "'").list();
	}


}
