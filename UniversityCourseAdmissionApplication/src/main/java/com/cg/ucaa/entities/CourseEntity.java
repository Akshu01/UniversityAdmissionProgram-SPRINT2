package com.cg.ucaa.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * This is an Entity class
 */
@Entity
@Table(name = "courses")
public class CourseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * primary-key
	 */
	@Id
	@Column(name = "course_id")
	private Long courseId;

	/**
	 * course name cannot be null/blank
	 **/
	@Column(name = "course_name", length = 30)
	private String courseName;

	/**
	 * course duration cannot be null/blank
	 **/
	@Column(name = "course_duration", length = 20)
	private String courseDuration;

	/**
	 * course start date cannot be null/blank
	 **/
	@Column(name = "start_Date")
	private LocalDate courseStartDate;

	/**
	 * course end date cannot be null/blank
	 **/
	@Column(name = "end_Date")
	private LocalDate courseEndDate;

	/**
	 * course end date cannot be of past
	 */
	@Column(name = "course_fees", length = 10)
	private String courseFees;

	/**
	 * join column with University Staff Member Entity(Many-to-one)
	 **/
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id")
	private UniversityStaffMemberEntity universityStaffMember;

	/**
	 * mapped with Course Entity(One-to-many)
	 */
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AdmissionEntity> admissionCourse;

	/**
	 * default constructor
	 **/
	public CourseEntity() {
		/* no implementation */
	}

	/**
	 * parameterized constructor
	 **/
	public CourseEntity(Long courseId, String courseName, String courseDuration, LocalDate courseStartDate,
			LocalDate courseEndDate, String courseFees, UniversityStaffMemberEntity universityStaffMember) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseFees = courseFees;
		this.universityStaffMember = universityStaffMember;
	}

	/**
	 * getters and setters
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(String courseDuration) {
		this.courseDuration = courseDuration;
	}

	public LocalDate getCourseStartDate() {
		return courseStartDate;
	}

	public void setCourseStartDate(LocalDate courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	public LocalDate getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(LocalDate courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public String getCourseFees() {
		return courseFees;
	}

	public void setCourseFees(String courseFees) {
		this.courseFees = courseFees;
	}

	@JsonBackReference
	public UniversityStaffMemberEntity getUniversityStaffMember() {
		return universityStaffMember;
	}

	public void setUniversityStaffMember(UniversityStaffMemberEntity universityStaffMember) {
		this.universityStaffMember = universityStaffMember;
	}

	public List<AdmissionEntity> getAdmissionCourse() {
		return admissionCourse;
	}

	public void setAdmissionCourse(List<AdmissionEntity> admissionCourse) {
		this.admissionCourse = admissionCourse;
	}

	/**
	 * overriding hashCode and equals method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseDuration == null) ? 0 : courseDuration.hashCode());
		result = prime * result + ((courseEndDate == null) ? 0 : courseEndDate.hashCode());
		result = prime * result + ((courseFees == null) ? 0 : courseFees.hashCode());
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result + ((courseStartDate == null) ? 0 : courseStartDate.hashCode());
		result = prime * result + ((universityStaffMember == null) ? 0 : universityStaffMember.hashCode());
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
		CourseEntity other = (CourseEntity) obj;
		if (courseDuration == null) {
			if (other.courseDuration != null)
				return false;
		} else if (!courseDuration.equals(other.courseDuration))
			return false;
		if (courseEndDate == null) {
			if (other.courseEndDate != null)
				return false;
		} else if (!courseEndDate.equals(other.courseEndDate))
			return false;
		if (courseFees == null) {
			if (other.courseFees != null)
				return false;
		} else if (!courseFees.equals(other.courseFees))
			return false;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseStartDate == null) {
			if (other.courseStartDate != null)
				return false;
		} else if (!courseStartDate.equals(other.courseStartDate))
			return false;
		if (universityStaffMember == null) {
			if (other.universityStaffMember != null)
				return false;
		} else if (!universityStaffMember.equals(other.universityStaffMember))
			return false;
		return true;
	}

	/**
	 * corresponding toString() method
	 */
	@Override
	public String toString() {
		return String.format(
				"CourseEntity [courseId=%s, courseName=%s, courseDuration=%s, courseStartDate=%s, courseEndDate=%s, courseFees=%s, universityStaffMember=%s]",
				courseId, courseName, courseDuration, courseStartDate, courseEndDate, courseFees,
				universityStaffMember);
	}

}