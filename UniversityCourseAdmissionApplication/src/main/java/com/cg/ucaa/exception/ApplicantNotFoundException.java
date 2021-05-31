package com.cg.ucaa.exception;



public class ApplicantNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;

	public ApplicantNotFoundException(String errorMessage) {
		super(errorMessage);
	}

}
