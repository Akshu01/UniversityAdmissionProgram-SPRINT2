package com.cg.ucaa.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This is a Model class
 * @author Akshat Kumar
 *
 */
public class UniversityStaffMemberModel {

	/**
	 * primary key
	 **/
	private Long staffId;

	/**
	 * input password cannot be null/blank should be unique
	 **/
	@NotNull(message = "password cannot be null")
	@NotBlank(message = "password cannot be blank")
	private String password;

	/**
	 * role cannot be null/blank
	 **/
	@NotNull(message = "role cannot be null")
	@NotBlank(message = "role cannot be blank")
	private String role;
	

	/**
	 * default constructor
	 **/
	public UniversityStaffMemberModel() {
		/* no implementation */
	}
	
	/**
	 * parameterized constructor
	 **/
	public UniversityStaffMemberModel(Long staffId,
			@NotNull(message = "password cannot be null") @NotBlank(message = "password cannot be blank") String password,
			@NotNull(message = "role cannot be null") @NotBlank(message = "role cannot be blank") String role) {
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
	
	/**
	 * over-riding hashCode and equals 
	 **/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		UniversityStaffMemberModel other = (UniversityStaffMemberModel) obj;
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
	 **/
	@Override
	public String toString() {
		return String.format("UniversityStaffMemberModel [staffId=%s, password=%s, role=%s]", staffId, password, role);
	}

}
