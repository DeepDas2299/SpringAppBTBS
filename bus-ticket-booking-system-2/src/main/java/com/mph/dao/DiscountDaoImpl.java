package com.mph.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mph.entity.Discount;

@Repository
public class DiscountDaoImpl implements DiscountDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Discount> getAllDiscounts() {
		return getSession().createQuery("select d from Discount d").list();
	}

	@Override
	public Discount getDiscountById(long id) {
		return (Discount) getSession().createQuery("select d from Discount d where discountId=:id").setParameter("id", id)
				.uniqueResult();
	}

	@Override
	public List<Discount> addDiscount(Discount discount) {
		getSession().save(discount);
		return getAllDiscounts();
	}

	@Override
	public List<Discount> updateDiscount(Discount discount) {
		getSession().merge(discount);
		return getAllDiscounts();
	}

	@Override
	public List<Discount> deleteDiscount(Discount discount) {
		getSession().evict(discount);
		getSession().delete(discount);
		return getAllDiscounts();
	}
	@Override
	public List<Discount> getDiscountByBusId(long id) {
		Criteria c = getSession().createCriteria(Discount.class);
		c.add(Restrictions.eq("busId", id));
		return c.list();
	}

}
