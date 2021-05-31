package com.cg.ucaa.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "admissions")
@Table(name = "admissions")
public class AdmissionEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * primary key
	 */
	@Id 
	@Column(name = "admission_id")
	private Long admissionId;
	
	/**
	 * ManyToOne mapping with CourseEntity
	 */
	@ManyToOne 
	@JoinColumn(name = "course_id")
	private CourseEntity course;
	
	 /**
	  * OneToOne mapping with ApplicantEntity
	  */
	@OneToOne
	@JoinColumn(name = "applicant_id")
	private ApplicantEntity applicant;

	@Column(name = "admission_date")
	private LocalDate admissionDate;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private AdmissionStatus admissionStatus;
	
	 /**
	  * Join column with AdmissionCommiteeMemberEntity
	  */
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private AdmissionCommiteeMemberEntity admissionComMember;

	public AdmissionEntity() {
		/*
		 * default constructor no implementation
		 */
	}
	
	// parameterized constructor
		public AdmissionEntity(Long admissionId, LocalDate admissionDate, AdmissionStatus admissionStatus,CourseEntity course,
				ApplicantEntity applicant, AdmissionCommiteeMemberEntity admissionComMember) {
			super();
			this.admissionId = admissionId;
			this.admissionDate = admissionDate;
			this.admissionStatus = admissionStatus;
			this.course = course;
			this.applicant = applicant;
			this.admissionComMember = admissionComMember;
		}


	// parameterized constructor
	public AdmissionEntity(Long admissionId, LocalDate admissionDate, AdmissionStatus admissionStatus) {
		super();
		this.admissionId = admissionId;
		this.admissionDate = admissionDate;
		this.admissionStatus = admissionStatus;
	}
	
	// getters and setters
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

	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public ApplicantEntity getApplicant() {
		return applicant;
	}

	public void setApplicant(ApplicantEntity applicant) {
		this.applicant = applicant;
	}

	public AdmissionCommiteeMemberEntity getAdmissionComMember() {
		return admissionComMember;
	}

	public void setAdmissionComMember(AdmissionCommiteeMemberEntity admissionComMember) {
		this.admissionComMember = admissionComMember;
	}

	// overriding hashCode() and equals()
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admissionComMember == null) ? 0 : admissionComMember.hashCode());
		result = prime * result + ((admissionDate == null) ? 0 : admissionDate.hashCode());
		result = prime * result + ((admissionId == null) ? 0 : admissionId.hashCode());
		result = prime * result + ((admissionStatus == null) ? 0 : admissionStatus.hashCode());
		result = prime * result + ((applicant == null) ? 0 : applicant.hashCode());
		result = prime * result + ((course == null) ? 0 : course.hashCode());
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
		AdmissionEntity other = (AdmissionEntity) obj;
		if (admissionComMember == null) {
			if (other.admissionComMember != null)
				return false;
		} else if (!admissionComMember.equals(other.admissionComMember))
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
		if (applicant == null) {
			if (other.applicant != null)
				return false;
		} else if (!applicant.equals(other.applicant))
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		return true;
	}
	
	/**
	 * @Override toString method to print output
	 */
	@Override
	public String toString() {
		return String.format(
				"AdmissionEntity [admissionId=%s, course=%s, applicant=%s, admissionDate=%s, admissionStatus=%s, admissionComMember=%s]",
				admissionId, course, applicant, admissionDate, admissionStatus, admissionComMember);
	}
	

}
