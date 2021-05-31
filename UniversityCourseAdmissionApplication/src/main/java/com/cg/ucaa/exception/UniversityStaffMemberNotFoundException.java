package com.cg.ucaa.exception;

/**
 * Exception class to throw user defined exception
 * @author Akshat Kumar
 *
 */
public class UniversityStaffMemberNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UniversityStaffMemberNotFoundException(String errormessage) {
		super(errormessage);
	}
}
