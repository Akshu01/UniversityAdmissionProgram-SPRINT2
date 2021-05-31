package com.cg.ucaa.models;

import java.time.LocalDate;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

/**
 * This is a Model class
 */
public class CourseModel {

	/**
	 * primary-key
	 */
	@NotNull(message = "course Id cannot be null")
	private Long courseId;

	/**
	 * course name cannot be null/blank
	 */
	@NotNull(message = "course name cannot be null")
	@NotBlank(message = "course name cannot be blank")
	private String courseName;

	/**
	 * course duration cannot be null/blank
	 */
	@NotNull(message = "course duration cannot be null")
	@NotBlank(message = "course duration cannot be blank")
	private String courseDuration;

	/**
	 * course start date cannot be null/blank
	 */
	@PastOrPresent
	private LocalDate courseStartDate;

	/**
	 * course end date cannot be of past
	 */
	@Future
	private LocalDate courseEndDate;

	/**
	 * course fees cannot be null/blank
	 */
	@NotNull(message = "course fees cannot be null")
	@NotBlank(message = "course fees cannot be blank")
	@Min(value = 0, message = "fees cannot be negative")
	private String courseFees;

	//private UniversityStaffMemberModel universityStaffMember;
	private Long staff_id;

	/**
	 * default constructor
	 **/
	public CourseModel() {
		/* no implementation */
	}

	/**
	 * parameterized constructor
	 **/
//	public CourseModel(@NotNull(message = "course Id cannot be null") Long courseId,
//			@NotNull(message = "course name cannot be null") @NotBlank(message = "course name cannot be blank") String courseName,
//			@NotNull(message = "course duration cannot be null") @NotBlank(message = "course duration cannot be blank") String courseDuration,
//			@PastOrPresent LocalDate courseStartDate, @Future LocalDate courseEndDate,
//			@NotNull(message = "course fees cannot be null") @NotBlank(message = "course fees cannot be blank") @Min(value = 0, message = "fees cannot be negative") String courseFees,
//			UniversityStaffMemberModel universityStaffMember) {
//		super();
//		this.courseId = courseId;
//		this.courseName = courseName;
//		this.courseDuration = courseDuration;
//		this.courseStartDate = courseStartDate;
//		this.courseEndDate = courseEndDate;
//		this.courseFees = courseFees;
//		this.universityStaffMember = universityStaffMember;
//	}
	
	public CourseModel(@NotNull(message = "course Id cannot be null") Long courseId,
			@NotNull(message = "course name cannot be null") @NotBlank(message = "course name cannot be blank") String courseName,
			@NotNull(message = "course duration cannot be null") @NotBlank(message = "course duration cannot be blank") String courseDuration,
			@PastOrPresent LocalDate courseStartDate, @Future LocalDate courseEndDate,
			@NotNull(message = "course fees cannot be null") @NotBlank(message = "course fees cannot be blank") @Min(value = 0, message = "fees cannot be negative") String courseFees,
			Long staff_id) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDuration = courseDuration;
		this.courseStartDate = courseStartDate;
		this.courseEndDate = courseEndDate;
		this.courseFees = courseFees;
		this.staff_id = staff_id;
	}
	
	/**
	 * corresponding getters and setters
	 */
	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
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

	public Long getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(Long staff_id) {
		this.staff_id = staff_id;
	}

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
		result = prime * result + ((staff_id == null) ? 0 : staff_id.hashCode());
		return result;
	}
	
	/**
	 * over-riding hashCode and equals
	 **/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourseModel other = (CourseModel) obj;
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
		if (staff_id == null) {
			if (other.staff_id != null)
				return false;
		} else if (!staff_id.equals(other.staff_id))
			return false;
		return true;
	}
	
	/**
	 * corresponding toString method
	 **/
	@Override
	public String toString() {
		return String.format(
				"CourseModel [courseId=%s, courseName=%s, courseDuration=%s, courseStartDate=%s, courseEndDate=%s, courseFees=%s, staff_id=%s]",
				courseId, courseName, courseDuration, courseStartDate, courseEndDate, courseFees, staff_id);
	}
	

}