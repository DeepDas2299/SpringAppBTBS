package com.mph.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Bus;
import com.mph.entity.Discount;
import com.mph.service.DiscountService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},allowedHeaders = "*")

@RequestMapping("/discount")
/**
 * @author Deep Das
 * @version 1.0
 */
public class DiscountController {
	@Autowired
	DiscountService discountService;
	private static final Logger logger = Logger.getLogger("DiscountController.class");
	
	/**
	 * This method is used to get all Discounts.
	 * 
	 * @return ResponseEntity This returns a list of Discounts.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Discount>> getAllDiscounts() {
		logger.info("Getting all Discounts");
		List<Discount> discountList = discountService.getAllDiscounts();
		if (discountList == null)
			return new ResponseEntity<List<Discount>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Discount>>(discountList, HttpStatus.OK);
	}
	/**
	 * This method is used to get Discount by Id.
	 * 
	 * @param id This parameter is used to get the Discount by id.
	 * @return ResponseEntity This returns a Discount with the given by id.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Discount> getDiscount(@PathVariable long id) {
		logger.info("Getting Discount with ID : " + id);
		Discount discount = discountService.getDiscountById(id);
		if (discount == null)
			return new ResponseEntity<Discount>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<Discount>(discount, HttpStatus.OK);
	}
	/**
	 * This method is used to get Discount by bus Id.
	 * 
	 * @param id This parameter is used to get the Discount by bus  id.
	 * @return ResponseEntity This returns a Discount with the given bus id.
	 */
	@GetMapping("/bus/{id}")
	public ResponseEntity<List<Discount>> getDiscountByBusId(@PathVariable long id) {
		logger.info("Getting Discount for Bus : " + id);
		List<Discount> discountList = discountService.getDiscountByBusId(id);
		if (discountList == null)
			return new ResponseEntity<List<Discount>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Discount>>(discountList, HttpStatus.OK);
	}
	/**
	 * This method is used to add the Discount.
	 * @param discount model passed down as the request body
	 * @return This returns a ResponseEntity  with a list of Discounts.
	 */
	@PostMapping("/add")
	public ResponseEntity<List<Discount>> addDiscount(@RequestBody Discount discount) {
		logger.info("Adding Discount for Bus : " + discount.getBusId());
		List<Discount> discountList = discountService.addDiscount(discount);
		if (discountList == null)
			return new ResponseEntity<List<Discount>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Discount>>(discountList, HttpStatus.OK);
	}
	/**
	 * This method is used to update the Discount.
	 * @param discount model passed down as the request body
	 * @return This returns a ResponseEntity  with a list of Discounts.
	 */
	@PutMapping("/update")
	public ResponseEntity<List<Discount>> updateDiscount(@RequestBody Discount discount) {
		logger.info("Updating Discount : " + discount.getDiscountId());
		List<Discount> discountList = discountService.updateDiscount(discount);
		if (discountList == null)
			return new ResponseEntity<List<Discount>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Discount>>(discountList, HttpStatus.OK);
	}
	/**
	 * This method is used to delete the Discount by id.
	 * @param id This parameter is used to delete the Discount by id.
	 * @return This returns a ResponseEntity  with a list of Discounts.
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Discount>> deleteDiscount(@PathVariable("id") long id) {
		logger.info("Deleting Discount : " +id);
		List<Discount> discountList = discountService.deleteDiscount(id);
		if (discountList == null)
			return new ResponseEntity<List<Discount>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Discount>>(discountList, HttpStatus.OK);
	}
}