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

import com.mph.entity.JourneyDetails;
import com.mph.entity.JourneySearchModel;
import com.mph.service.JourneyDetailsService;

@RequestMapping("/journey")
@RestController
@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},allowedHeaders = "*")
/**
 * @author Deep Das
 * @version 1.0
 */
public class JourneyDetailsController {
	@Autowired
	JourneyDetailsService journeyDetailsService;
	private static final Logger logger = Logger.getLogger("JourneyDetailsController.class");
	
	/**
	 * This method is used to get all JourneyDetails.
	 * 
	 * @return ResponseEntity This returns a list of JourneyDetails.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<JourneyDetails>> getAllJourneyDetails() {
		logger.info("Getting All Journeys");
		List<JourneyDetails> journeyDetailsList = journeyDetailsService.getAllJourneyDetails();
		if (journeyDetailsList == null)
			return new ResponseEntity<List<JourneyDetails>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<JourneyDetails>>(journeyDetailsList, HttpStatus.OK);
	}
	/**
	 * This method is used to get JourneyDetails by Id.
	 * 
	 * @param id This parameter is used to get the JourneyDetails by id.
	 * @return ResponseEntity This returns a JourneyDetails with the given by id.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<JourneyDetails> getJourneyDetails(@PathVariable("id") long id) {
		logger.info("Getting Journey with ID : " + id);
		JourneyDetails journeyDetails = journeyDetailsService.getJourneyDetailsById(id);
		if (journeyDetails != null)
			return new ResponseEntity<JourneyDetails>(journeyDetails, HttpStatus.OK);
		return new ResponseEntity<JourneyDetails>(HttpStatus.NO_CONTENT);
	}
	/**
	 * This method is used to add the JourneyDetails.
	 * @param journeyDetails This is passed down as the request body
	 * @param result It has the result from the validations of the hibernate validators
	 * @return This returns a ResponseEntity  with a list of JourneyDetails.
	 */
	@PostMapping("/add")
	public ResponseEntity<List<JourneyDetails>> addJourneyDetails(@Valid @RequestBody JourneyDetails journeyDetails,BindingResult result) {
		logger.info("Adding Journey for Bus : " + journeyDetails.getBus().getBusId());
		List<JourneyDetails> journeyDetailsList = journeyDetailsService.addJourneyDetails(journeyDetails);
		if (journeyDetailsList == null)
			return new ResponseEntity<List<JourneyDetails>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<JourneyDetails>>(journeyDetailsList, HttpStatus.OK);
	}
	/**
	 * This method is used to update the JourneyDetails.
	 * 
	 * @param journeyDetails This is passed down as the request body
	 * @return This returns a ResponseEntity  with a list of JourneyDetails.
	 */

	@PutMapping("/update")
	public ResponseEntity<List<JourneyDetails>> updateJourneyDetails(@RequestBody JourneyDetails journeyDetails) {
		logger.info("Updating Journey with ID : " + journeyDetails.getJourneyID());
		List<JourneyDetails> journeyDetailsList = journeyDetailsService.updateJourneyDetails(journeyDetails);
		if (journeyDetailsList == null)
			return new ResponseEntity<List<JourneyDetails>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<JourneyDetails>>(journeyDetailsList, HttpStatus.OK);
	}
	/**
	 * This method is used to delete the JourneyDetails.
	 * 
	 * @param id This parameter is used to delete the JourneyDetails by id.
	 * @return ResponseEntity This returns a list of JourneyDetails.
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<JourneyDetails>> deleteJourneyDetails(@PathVariable("id") long id) {
		logger.info("Deleting Journey with ID : " + id);
		List<JourneyDetails> journeyDetailsList = journeyDetailsService.deleteJourneyDetails(id);
		if (journeyDetailsList == null)
			return new ResponseEntity<List<JourneyDetails>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<JourneyDetails>>(journeyDetailsList, HttpStatus.OK);
	}
	/**
	 * This method is used to search the JourneyDetails.
	 * 
	 * @param search This parameter is used to search the JourneyDetails.
	 * @return ResponseEntity This returns a list of JourneyDetails.
	 */
	@PostMapping("/search")
	public ResponseEntity<List<JourneyDetails>> searchJourney(@RequestBody JourneySearchModel search) {
		logger.info("Searching Journey with source : " + search.getSource() + " dest : " + search.getDest());
		List<JourneyDetails> journeyDetailsList = journeyDetailsService.getJourneyBySearch(search.getSource(), search.getDest(), search.getDate());
		if (journeyDetailsList == null)
			return new ResponseEntity<List<JourneyDetails>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<JourneyDetails>>(journeyDetailsList, HttpStatus.OK);
	}
}