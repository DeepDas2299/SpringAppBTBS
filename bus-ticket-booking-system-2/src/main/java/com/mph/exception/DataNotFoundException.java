package com.mph.exception;


/**
 * This Exception class is for the DataNotFoundException 
 * @author Deep Das
 * @version 1.0
 */
public class DataNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataNotFoundException(String message) {
		super(message);

	}

}
