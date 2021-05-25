package com.mph.exception;


/**
 * This Exception class is for the DataAlreadyExistsException
 * @author Deep Das
 * @version 1.0
 */
public class DataAlreadyExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataAlreadyExistsException(String message) {
		super(message);

	}
}
