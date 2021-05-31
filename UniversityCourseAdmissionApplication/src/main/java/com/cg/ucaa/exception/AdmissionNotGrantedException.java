package com.cg.ucaa.exception;

public class AdmissionNotGrantedException extends Exception {

	private static final long serialVersionUID = 1L;

	
	public AdmissionNotGrantedException(String errorMessage) {
		super(errorMessage);
	}

}
