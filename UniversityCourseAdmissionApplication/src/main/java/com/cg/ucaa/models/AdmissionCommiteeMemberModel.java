package com.cg.ucaa.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AdmissionCommiteeMemberModel {

	/**
	 * auto-generated primary key
	 */
	private Long adminId;

	/**
	 * admin name should not be null/blank
	 */
	@NotNull(message = "admin name cannot be null")
	@NotBlank(message = "admin name cannot be blank")
	private String adminName;

	/**
	 * every admin must have unique contact
	 */
	@NotNull(message = "admin  contact cannot be null")
	@NotBlank(message = "admin contact cannot be blank")
	private String adminContact;

	/**
	 * default constructor
	 */
	public AdmissionCommiteeMemberModel() {
		/* no implementation */
	}

	/**
	 * parameterized constructor
	 **/

	public AdmissionCommiteeMemberModel(Long adminId, String adminName, String adminContact) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	/**
	 * corresponding getters and setters
	 */

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminContact() {
		return adminContact;
	}

	public void setAdminContact(String adminContact) {
		this.adminContact = adminContact;
	}

	/**
	 * over-riding hashCode and equals
	 **/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminContact == null) ? 0 : adminContact.hashCode());
		result = prime * result + ((adminId == null) ? 0 : adminId.hashCode());
		result = prime * result + ((adminName == null) ? 0 : adminName.hashCode());
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
		AdmissionCommiteeMemberModel other = (AdmissionCommiteeMemberModel) obj;
		if (adminContact == null) {
			if (other.adminContact != null)
				return false;
		} else if (!adminContact.equals(other.adminContact))
			return false;
		if (adminId == null) {
			if (other.adminId != null)
				return false;
		} else if (!adminId.equals(other.adminId))
			return false;
		if (adminName == null) {
			if (other.adminName != null)
				return false;
		} else if (!adminName.equals(other.adminName))
			return false;
		return true;
	}

	/**
	 * corresponding toString method
	 **/

	@Override
	public String toString() {
		return String.format("AdmissionCommiteeMemberModel [adminId=%s, adminName=%s, adminContact=%s]", adminId,
				adminName, adminContact);
	}

}