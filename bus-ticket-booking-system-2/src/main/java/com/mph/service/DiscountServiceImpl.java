package com.mph.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.mph.dao.DiscountDao;
import com.mph.entity.Bus;
import com.mph.entity.Discount;
import com.mph.exception.DataAlreadyExistsException;
import com.mph.exception.DataNotFoundException;

@Service
@Transactional(isolation = Isolation.READ_COMMITTED)
public class DiscountServiceImpl implements DiscountService{

	@Autowired
	DiscountDao discountDao;
	
	@Override
	public List<Discount> getAllDiscounts() {
		
		return discountDao.getAllDiscounts();
	}

	@Override
	public Discount getDiscountById(long id) {
		
		return discountDao.getDiscountById(id);
	}

	@Override
	public List<Discount> addDiscount(Discount discount) {
		if (getDiscountById(discount.getDiscountId()) != null)
			throw new DataAlreadyExistsException("DIscount with ID : " + discount.getDiscountId() + " already exists");
		else {
			return discountDao.addDiscount(discount);
		}
	}

	@Override
	public List<Discount> updateDiscount(Discount discount) {
		if (getDiscountById(discount.getDiscountId()) == null)
			throw new DataNotFoundException("Discount with ID : " + discount.getDiscountId() + " not found" );
		else {
			return discountDao.updateDiscount(discount);
		}
	}

	@Override
	public List<Discount> deleteDiscount(long id) {
		Discount discount = getDiscountById(id);
		if (discount == null)
			throw new DataNotFoundException("Discount with ID : " + id + " not found" );
		else
			return discountDao.deleteDiscount(discount);
	}

	@Override
	public List<Discount> getDiscountByBusId(long id) {
		return discountDao.getDiscountByBusId(id);
	}

}
