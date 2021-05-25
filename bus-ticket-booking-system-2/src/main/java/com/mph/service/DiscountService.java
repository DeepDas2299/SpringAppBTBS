package com.mph.service;

import java.util.List;

import com.mph.entity.Discount;

/**
 * @author Pranathi G
 * @version 1.0
 */
public interface DiscountService {
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
	 * @return Bus This returns a list of discounts.
	 */
	public Discount getDiscountById(long id);
	/**
	   * This method is used to add Discount.
	   * @param discount this is the parameter to addDiscount method
	   * @return List This returns a list of Discounts.
	   */
	public List<Discount> addDiscount(Discount discount);
	/**
	   * This method is used to update discount.
	   * @param discount this is the parameter to updateDiscount method
	   * @return List This returns a list of discounts.
	   */
	public List<Discount> updateDiscount(Discount discount);
	/**
	   * This method is used to delete discount.
	   * @param id this is the parameter to deleteDiscount method
	   * @return List This returns a list of discounts.
	   */
	public List<Discount> deleteDiscount(long id);
	/**
	 * This method is used to get discount by bus Id.
	 * @param id This is the parameter to  getDiscountByBusId method.
	 * @return Bus This returns a list of discounts.
	 */
	public List<Discount> getDiscountByBusId(long id);
}