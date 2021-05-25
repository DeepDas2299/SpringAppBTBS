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
import com.mph.service.BusService;

@RestController
@CrossOrigin(origins = "*", allowCredentials = "false", methods = {RequestMethod.GET,RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT},allowedHeaders = "*")

@RequestMapping("/bus")
/**
 * @author Deep Das
 * @version 1.0
 */
public class BusController {
	@Autowired
	BusService busService;
	private static final Logger logger = Logger.getLogger("BusController.class");
	
	
	/**
	 * This method is used to get all buses.
	 * 
	 * @return ResponseEntity This returns a list of Buses.
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Bus>> getAllBuses() {
		logger.info("Getting All Buses");
		List<Bus> busList = busService.getAllBuses();
		if (busList == null)
			return new ResponseEntity<List<Bus>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Bus>>(busList, HttpStatus.OK);
	}
	/**
	 * This method is used to get bus by Id.
	 * 
	 * @param id This parameter is used to get the bus by id.
	 * @return ResponseEntity This returns a Bus with the given by id.
	 */

	@GetMapping("/{id}")
	public ResponseEntity<Bus> getBus(@PathVariable("id") long id) {
		logger.info("Getting Bus with ID : " + id);
		Bus bus = busService.getBusById(id);
		if (bus != null)
			return new ResponseEntity<Bus>(bus, HttpStatus.OK);
		return new ResponseEntity<Bus>(HttpStatus.NO_CONTENT);
	}
	/**
	 * This method is used to add the bus.
	 * @param bus This is passed down as the request body
	 * @param result It has the result from the validations of the hibernate validators
	 * @return This returns a ResponseEntity  with a list of Buses.
	 */

	@PostMapping("/add")
	public ResponseEntity<List<Bus>> addBus(@Valid @RequestBody Bus bus, BindingResult result) {
		logger.info("Adding Bus : " + bus.getBusName());
		List<Bus> busList = busService.addBus(bus);
		if (busList == null)
			return new ResponseEntity<List<Bus>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Bus>>(busList, HttpStatus.OK);
	}
	/**
	 * This method is used to update the bus.
	 * 
	 * @param bus This is passed down as the request body
	 * @return This returns a ResponseEntity  with a list of Buses.
	 */

	@PutMapping("/update")
	public ResponseEntity<List<Bus>> updateBus(@RequestBody Bus bus) {
		logger.info("Updating Bus : " + bus.getBusId());
		List<Bus> busList = busService.updateBus(bus);
		if (busList == null)
			return new ResponseEntity<List<Bus>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Bus>>(busList, HttpStatus.OK);
	}
	/**
	 * This method is used to delete the bus.
	 * 
	 * @param id This parameter is used to delete the bus by id.
	 * @return ResponseEntity This returns a list of Buses.
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Bus>> deleteBus(@PathVariable("id") long id) {
		logger.info("Deleting Bus : " + id);
		List<Bus> busList = busService.deleteBus(id);
		if (busList == null)
			return new ResponseEntity<List<Bus>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Bus>>(busList, HttpStatus.OK);
	}

}