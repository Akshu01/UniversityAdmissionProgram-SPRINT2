package com.cg.ucaa.exception;

/**
 * Exception class to throw user defined exceptions
 * @author Akshat Kumar
 *
 */
public class LoginFailedException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public LoginFailedException(String errMessage) {
		super(errMessage);
	}

}
