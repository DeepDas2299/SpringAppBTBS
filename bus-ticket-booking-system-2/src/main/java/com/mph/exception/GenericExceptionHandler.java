package com.mph.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mph.entity.ErrorMessage;

/**
 * This Exception class is for the GenericExceptionHandler 
 * @author Deep Das
 * @version 1.0
 */
@RestControllerAdvice
public class GenericExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleBookingAlreadyExists(Exception e) {
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(500);
		error.setErrorMessage(e.getMessage());
		return new ResponseEntity<ErrorMessage>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
