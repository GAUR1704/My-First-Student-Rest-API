package com.prowings.exception;

public class InvalidStudentException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidStudentException() {
		super();
	}

	public InvalidStudentException(String message) {
		super(message);
	}

}
