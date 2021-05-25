package com.mph.dao;

import java.util.List;

import com.mph.entity.Bus;
/**
 * @author Farnaz S
 * @version 1.0
 */
public interface BusDao {
	/**
	 * This method is used to get all buses.
	 * 
	 * @return List This returns a list of Buses.
	 */
	public List<Bus> getAllBuses();
	/**
	 * This method is used to get bus by Id.
	 * 
	 * @param id This is the parameter to getBusById method.
	 * @return Bus This returns a list of Bus.
	 */
	public Bus getBusById(long id);
	/**
	   * This method is used to add bus.
	   * @param bus this is the parameter to addBus method
	   * @return List This returns a list of Buses.
	   */
	public List<Bus> addBus(Bus bus);
	/**
	   * This method is used to update bus.
	   * @param bus this is the parameter to updateBus method
	   * @return List This returns a list of Buses.
	   */
	public List<Bus> updateBus(Bus bus);
	/**
	   * This method is used to delete bus.
	   * @param bus this is the parameter to deleteBus method
	   * @return List This returns a list of Buses.
	   */
	public List<Bus> deleteBus(Bus bus);
}
