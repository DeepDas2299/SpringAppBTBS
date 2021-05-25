package com.mph.dao;

import java.util.List;

import com.mph.entity.Discount;

/**
 * @author Farnaz S
 * @version 1.0
 */

public interface DiscountDao {
	/**
	 * This method is used to get all discounts.
	 * 
	 * @return List This returns a list of discounts.
	 */
	public List<Discount> getAllDiscounts();
	/**
	 * This method is used to get discount by Id.
	 * 
	 * @param id This is the parameter to getDiscountById method.
	 * @return discount This returns a list of discount.
	 */
	public Discount getDiscountById(long id);
	/**
	   * This method is used to add discount.
	   * @param discount this is the parameter to addDiscount method
	   * @return List This returns a list of discounts.
	   */
	public List<Discount> addDiscount(Discount discount);
	/**
	   * This method is used to update discount.
	   * @param discount this is the parameter to updateDiscount method
	   * @return List This returns a list of discount .
	   */
	public List<Discount> updateDiscount(Discount discount);
	/**
	   * This method is used to delete discount
	   * @param discount this is the parameter to deleteDiscount method
	   * @return List This returns a list of Buses.
	   */
	public List<Discount> deleteDiscount(Discount discount);
	/**
	 * This method is used to get discount by Id.
	 * 
	 * @param id This is the parameter to getDiscountByBusId method.
	 * @return discount This returns a list of discount.
	 */
	public List<Discount> getDiscountByBusId(long id);
}
