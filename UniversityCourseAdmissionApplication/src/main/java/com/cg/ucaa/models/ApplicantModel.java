package com.cg.ucaa.models;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


public class ApplicantModel {

	
	private Long applicantId;
	
	/*
	 * applicant name should not be null/empty
	 */
	@NotEmpty(message = "Applicant name cannot be empty.")
	@NotNull(message = "Applicant name cannot be null.")
	private String applicantName;

	/*
	 * every admin must have unique contact
	 */	
	@Pattern(regexp = "[1-9][0-9]{9}", message = "Invalid Mobile Number")
	@NotEmpty(message = "Mobile number cannot be empty.")
	@NotNull(message = "Mobile number cannot be null.")
	private String mobileNumber;

	/*Applicant degree cannot be null or empty
	 * */
	@NotEmpty(message = "Applicant degree cannot be empty")
	@NotNull(message = "Applicant degree cannot be null")
	private String applicantDegree;

	/*Applicant graduation percent cannot be null or empty
	 * */
	@NotEmpty(message = "Applicant Graduation percent cannot be empty")
	@NotNull(message = "Applicant Graduation percent cannot be null")
	private BigDecimal applicantGradPercent;

	/*
	 * default constructor
	*/	
	public ApplicantModel() {
		// no implementation
	}
	
	/*
	 * parameterized constructor*/
	public ApplicantModel(Long applicantId,
			@NotEmpty(message = "Applicant name cannot be empty.") @NotNull(message = "Applicant name cannot be null.") String applicantName,
			@Pattern(regexp = "[1-9][0-9]{9}", message = "Invalid Mobile Number") @NotEmpty(message = "Mobile number cannot be empty.") @NotNull(message = "Mobile number cannot be null.") String mobileNumber,
			@NotEmpty(message = "Applicant degree cannot be empty") @NotNull(message = "Applicant degree cannot be null") String applicantDegree,
			@NotEmpty(message = "Applicant Graduation percent cannot be null") @NotNull(message = "Applicant Graduation percent cannot be null") BigDecimal applicantGradPercent) {
		super();
		this.applicantId = applicantId;
		this.applicantName = applicantName;
		this.mobileNumber = mobileNumber;
		this.applicantDegree = applicantDegree;
		this.applicantGradPercent = applicantGradPercent;
	}

	/**
	 * corresponding getters and setters
	 */	
	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getApplicantDegree() {
		return applicantDegree;
	}

	public void setApplicantDegree(String applicantDegree) {
		this.applicantDegree = applicantDegree;
	}

	public BigDecimal getApplicantGradPercent() {
		return applicantGradPercent;
	}

	public void setApplicantGradPercent(BigDecimal applicantGradPercent) {
		this.applicantGradPercent = applicantGradPercent;
	}

	/**
	 * over-riding hashCode and equals 
	 **/	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applicantDegree == null) ? 0 : applicantDegree.hashCode());
		result = prime * result + ((applicantGradPercent == null) ? 0 : applicantGradPercent.hashCode());
		result = prime * result + ((applicantId == null) ? 0 : applicantId.hashCode());
		result = prime * result + ((applicantName == null) ? 0 : applicantName.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApplicantModel other = (ApplicantModel) obj;
		if (applicantDegree == null) {
			if (other.applicantDegree != null)
				return false;
		} else if (!applicantDegree.equals(other.applicantDegree))
			return false;
		if (applicantGradPercent == null) {
			if (other.applicantGradPercent != null)
				return false;
		} else if (!applicantGradPercent.equals(other.applicantGradPercent))
			return false;
		if (applicantId == null) {
			if (other.applicantId != null)
				return false;
		} else if (!applicantId.equals(other.applicantId))
			return false;
		if (applicantName == null) {
			if (other.applicantName != null)
				return false;
		} else if (!applicantName.equals(other.applicantName))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		return true;
	}
	
	/**
	 * corresponding toString method
	 **/	
	@Override
	public String toString() {
		return String.format(
				"ApplicantModel [applicantId=%s, applicantName=%s, mobileNumber=%s, applicantDegree=%s, applicantGradPercent=%s]",
				applicantId, applicantName, mobileNumber, applicantDegree, applicantGradPercent);
	}


}
