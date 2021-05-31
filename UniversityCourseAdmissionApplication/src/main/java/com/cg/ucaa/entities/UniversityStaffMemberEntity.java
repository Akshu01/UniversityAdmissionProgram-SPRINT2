package com.cg.ucaa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This is an Entity class
 * @author Akshat Kumar
 *
 */
@Entity
@Table(name = "ustaffmembers")
public class UniversityStaffMemberEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * primary-key
	 */
	@Id
	@Column(name = "staff_id")
	private Long staffId;

	/**
	 * input password cannot be null/blank provided with unique constraint
	 **/
	@Column(name = "password", length = 20, unique = true)
	private String password;

	/**
	 * role cannot be null/blank
	 **/
	@Column(name = "role", length = 30)
	private String role;
	
	/**
	 * mapped with University Entity(One-to-many)
	 */
	@OneToMany(mappedBy = "universityStaffMember",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<CourseEntity> course;

	/**
	 * default constructor
	 **/
	public UniversityStaffMemberEntity() {
		/* no implementation */
	}
	
	/**
	 * parameterized constructor
	 */
	public UniversityStaffMemberEntity(Long staffId, String password, String role) {
		super();
		this.staffId = staffId;
		this.password = password;
		this.role = role;
	}
	
	/**
	 * corresponding getters and setters 
	 */
	public Long getStaffId() {
		return staffId;
	}

	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<CourseEntity> getCourse() {
		return course;
	}

	public void setCourse(List<CourseEntity> course) {
		this.course = course;
	}
	
	/**
	 * overriding hashCode and equals method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((staffId == null) ? 0 : staffId.hashCode());
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
		UniversityStaffMemberEntity other = (UniversityStaffMemberEntity) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (staffId == null) {
			if (other.staffId != null)
				return false;
		} else if (!staffId.equals(other.staffId))
			return false;
		return true;
	}
	
	/**
	 * corresponding toString() method
	 */
	@Override
	public String toString() {
		return String.format(
				"UniversityStaffMemberEntity [staffId=%s, password=%s, role=%s, course=%s]",
				staffId, password, role, course);
	}

}
