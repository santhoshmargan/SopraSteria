package com.soprasteria.exceptions;

public class RecordNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException(String str) {
		super(str);
	}

}
