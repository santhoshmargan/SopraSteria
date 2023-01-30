package com.soprasteria.exceptions;

public class RecordAlreadyExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RecordAlreadyExistsException(String str) {
		super(str);
	}

}
