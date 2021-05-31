package com.cg.ucaa.exception;
/**
 * Exception class to throw user defined exception
 */
public class CourseNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public CourseNotFoundException(String errormessage) {
		super(errormessage);
	}

}
