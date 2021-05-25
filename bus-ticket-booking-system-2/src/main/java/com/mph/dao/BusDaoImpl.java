package com.mph.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Bus;

@Repository
public class BusDaoImpl implements BusDao {

	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Bus> getAllBuses() {
		return getSession().createQuery("select b from Bus_Details b").list();
	}

	@Override
	public Bus getBusById(long id) {
		return (Bus) getSession().createQuery("select b from Bus_Details b where busId=:id").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public List<Bus> addBus(Bus bus) {
		getSession().save(bus);
		return getAllBuses();
	}

	@Override
	public List<Bus> updateBus(Bus bus) {
		getSession().merge(bus);
		return getAllBuses();
	}

	@Override
	public List<Bus> deleteBus(Bus bus) {
		getSession().evict(bus);
		getSession().delete(bus);
		return getAllBuses();
	}

}
