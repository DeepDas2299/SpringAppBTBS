package com.mph.service;

import java.util.List;

import com.mph.entity.JourneyDetails;

/**
 * @author Deep Das
 * @version 1.0
 */
public interface JourneyDetailsService {
	public JourneyDetails getJourneyDetailsById(long id);

	/**
	 * This method is used to get all JourneyDetails.
	 * 
	 * @return List This returns a list of JourneyDetails.
	 */
	public List<JourneyDetails> getAllJourneyDetails();

	/**
	 * This method is used to add JourneyDetails.
	 * 
	 * @param journeyDetails this is the parameter to addJourneyDetails method
	 * @return List This returns a list of JourneyDetails.
	 */
	public List<JourneyDetails> addJourneyDetails(JourneyDetails journeyDetails);

	/**
	 * This method is used to update JourneyDetails.
	 * 
	 * @param journeyDetails this is the parameter to updateJourneyDetails method
	 * @return List This returns a list of JourneyDetails.
	 */
	public List<JourneyDetails> updateJourneyDetails(JourneyDetails journeyDetails);

	/**
	 * This method is used to delete JourneyDetails.
	 * 
	 * @param id this is the parameter to deleteJourneyDetails method
	 * @return List This returns a list of JourneyDetails.
	 */
	public List<JourneyDetails> deleteJourneyDetails(long id);

	/**
	 * This method is used to search JourneyDetails.
	 * 
	 * @param source this is the parameter to getJourneyBySearch method
	 * @param dest   this is the parameter to getJourneyBySearch method
	 * @param date   this is the parameter to getJourneyBySearch method
	 * @return List This returns a list of JourneyDetails.
	 */
	public List<JourneyDetails> getJourneyBySearch(String source, String dest, String date);
}
