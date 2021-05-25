package com.mph.dao;

import java.util.List;

import com.mph.entity.JourneyDetails;
/**
 * @author Farnaz S
 * @version 1.0
 */
public interface JourneyDetailsDao {
	/**
	 * This method is used to get JourneyDetailsById.
	 * 
	 * @param id This is the parameter to getJourneyDetailsById  method.
	 * @return JourneyDetails This returns a list of JourneyDetails .
	 */
	public JourneyDetails getJourneyDetailsById(long id);
	/**
	 * This method is used to get all journey details.
	 * 
	 * @return List This returns a list of journey details. .
	 */
	public List<JourneyDetails> getAllJourneyDetails();
	/**
	   * This method is used to add JourneyDetails .
	   * @param journeyDetails this is the parameter to addJourneyDetails method
	   * @return List This returns a list of JourneyDetails.
	   */

	public List<JourneyDetails> addJourneyDetails(JourneyDetails journeyDetails);
	/**
	   * This method is used to update JourneyDetails .
	   * @param journeyDetails this is the parameter to updateJourneyDetails method
	   * @return List This returns a list of JourneyDetails.
	   */
	public List<JourneyDetails> updateJourneyDetails(JourneyDetails journeyDetails);
	/**
	   * This method is used to delete JourneyDetails .
	   * @param journeyDetails this is the parameter to deleteJourneyDetails method
	   * @return List This returns a list of JourneyDetails.
	   */
	public List<JourneyDetails> deleteJourneyDetails(JourneyDetails journeyDetails);
	/**
	 * This method is used to get JourneyDetailsById.
	 * 
	 * @param id This is the parameter to getJourneyByBusId  method.
	 * @return JourneyDetails This returns a list of JourneyDetails .
	 */
	public List<JourneyDetails> getJourneyByBusId(long id);
	/**
	 * This method is used to get JourneyDetailsBySearch.
	 * @param dest This is the parameter to getJourneyBySearch method.
	 * @param source This is the parameter to getJourneyBySearch method.
	 * @param date This is the parameter to getJourneyBySearch method.
	 * @return JourneyDetails This returns a list of JourneyDetails .
	 */
	public List<JourneyDetails> getJourneyBySearch(String source, String dest, String date);
}
