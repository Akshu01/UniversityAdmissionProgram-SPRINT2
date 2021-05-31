package com.cg.ucaa.models;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import com.cg.ucaa.entities.AdmissionStatus;

public class AdmissionModel {
	
	private Long admissionId;
	
	/*Admission date cannot be a future date
	 */
	@PastOrPresent(message = "Admission Date cannot be a future date.")
	private LocalDate admissionDate;
	
	/*Admission Status cannot be empty or null
	 */
	@NotEmpty(message = "status cannot be empty")
	@NotNull(message = "status cannot be null")
	@Enumerated(EnumType.STRING)
	private AdmissionStatus admissionStatus;
	
	private Long courseId;
	
	private Long applicantId;
	
	private Long adminId;

	public AdmissionModel() {
		/*
		 * default constructor no implementation
		 */
	}	
	
	/**
	 * parameterized constructor
	 * @param admissionId
	 * @param admissionDate
	 * @param admissionStatus
	 */
	public AdmissionModel(Long admissionId,
			@PastOrPresent(message = "Admission Date cannot be a future date.") LocalDate admissionDate,
			@NotEmpty(message = "status cannot be empty") @NotNull(message = "status cannot be null") AdmissionStatus admissionStatus) {
		super();
		this.admissionId = admissionId;
		this.admissionDate = admissionDate;
		this.admissionStatus = admissionStatus;
	}
	
	public AdmissionModel(Long admissionId,
			@PastOrPresent(message = "Admission Date cannot be a future date.") LocalDate admissionDate,
			@NotEmpty(message = "status cannot be empty") @NotNull(message = "status cannot be null") AdmissionStatus admissionStatus,
			Long courseId, Long applicantId, Long adminId) {
		super();
		this.admissionId = admissionId;
		this.admissionDate = admissionDate;
		this.admissionStatus = admissionStatus;
		this.courseId = courseId;
		this.applicantId = applicantId;
		this.adminId = adminId;
	}

	//corresponding getters and setters
	public Long getAdmissionId() {
		return admissionId;
	}

	public void setAdmissionId(Long admissionId) {
		this.admissionId = admissionId;
	}

	public LocalDate getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(LocalDate admissionDate) {
		this.admissionDate = admissionDate;
	}

	public AdmissionStatus getAdmissionStatus() {
		return admissionStatus;
	}

	public void setAdmissionStatus(AdmissionStatus admissionStatus) {
		this.admissionStatus = admissionStatus;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getApplicantId() {
		return applicantId;
	}

	public void setApplicantId(Long applicantId) {
		this.applicantId = applicantId;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((admissionDate == null) ? 0 : admissionDate.hashCode());
		result = prime * result + ((admissionId == null) ? 0 : admissionId.hashCode());
		result = prime * result + ((admissionStatus == null) ? 0 : admissionStatus.hashCode());
		result = prime * result + ((applicantId == null) ? 0 : applicantId.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
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
		AdmissionModel other = (AdmissionModel) obj;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (admissionDate == null) {
			if (other.admissionDate != null)
				return false;
		} else if (!admissionDate.equals(other.admissionDate))
			return false;
		if (admissionId == null) {
			if (other.admissionId != null)
				return false;
		} else if (!admissionId.equals(other.admissionId))
			return false;
		if (admissionStatus != other.admissionStatus)
			return false;
		if (applicantId == null) {
			if (other.applicantId != null)
				return false;
		} else if (!applicantId.equals(other.applicantId))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(
				"AdmissionModel [admissionId=%s, admissionDate=%s, admissionStatus=%s, courseId=%s, applicantId=%s, adminId=%s]",
				admissionId, admissionDate, admissionStatus, courseId, applicantId, adminId);
	}
	
}
