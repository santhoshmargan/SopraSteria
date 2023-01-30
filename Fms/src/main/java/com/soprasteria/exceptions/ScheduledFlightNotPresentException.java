package com.soprasteria.exceptions;

public class ScheduledFlightNotPresentException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ScheduledFlightNotPresentException(String str) {
		super(str);
	}
}
