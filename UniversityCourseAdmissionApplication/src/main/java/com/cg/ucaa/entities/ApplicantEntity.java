package com.cg.ucaa.entities;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="applicants")
public class ApplicantEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/**
	 * auto-generated primary key
	 */	
	@Id
	@Column(name="applicant_id")
	private Long applicantId;
	
	@Column(name="applicant_name")
	private String applicantName;
	
	/**
	 * every admin must have unique contact
	 */	
	@Column(name="mobile_number")
	private String mobileNumber;
	
	@Column(name="applicant_degree")
	private String applicantDegree;
	
	@Column(name="applicant_grad_percent")
	private BigDecimal applicantGradPercent;
	
	/**
	 * mapped with Admission entity (One-to-One)
	 */	
	@OneToOne(mappedBy="applicant",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private AdmissionEntity admission;

	/**
	 * Default Constructor
	 */	
	public ApplicantEntity() {
		//no implementation
	}

	/**
	 * parameterized constructor
	 */	
	public ApplicantEntity(Long applicantId, String applicantName, String mobileNumber, String applicantDegree,
			BigDecimal applicantGradPercent) {
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

	public AdmissionEntity getAdmission() {
		return admission;
	}

	public void setAdmission(AdmissionEntity admission) {
		this.admission = admission;
	}
	
	/**
	 * over-riding hashCode and equals 
	 **/	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admission == null) ? 0 : admission.hashCode());
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
		ApplicantEntity other = (ApplicantEntity) obj;
		if (admission == null) {
			if (other.admission != null)
				return false;
		} else if (!admission.equals(other.admission))
			return false;
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
	 * corresponding toString() method
	 */	
	@Override
	public String toString() {
		return String.format(
				"ApplicantEntity [applicantId=%s, applicantName=%s, mobileNumber=%s, applicantDegree=%s, applicantGradPercent=%s]",
				applicantId, applicantName, mobileNumber, applicantDegree, applicantGradPercent);
	}	
	
}
