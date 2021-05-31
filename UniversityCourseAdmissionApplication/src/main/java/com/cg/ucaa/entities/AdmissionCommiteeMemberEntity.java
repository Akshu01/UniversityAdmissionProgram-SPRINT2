package com.cg.ucaa.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "admissioncommiteemember")
@Table(name = "admissioncommiteemember")
public class AdmissionCommiteeMemberEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * auto-generated primary key
	 */
	@Id
	@Column(name = "admin_id")
	@GeneratedValue
	private Long adminId;

	@Column(name = "admin_name")
	private String adminName;

	/**
	 * every admin must have unique contact
	 */
	@Column(name = "admin_contact", unique = true)
	private String adminContact;
	
	/**
	 * mapped with Admission result (One-to-One)
	 */
	@OneToMany(mappedBy="admissionComMember",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<AdmissionEntity> admissionResult;
	
	/**
	 * default constructor
	 **/
	public AdmissionCommiteeMemberEntity() {
		/* no implementation */
	}
	
	/**
	 * parameterized constructor
	 */
	public AdmissionCommiteeMemberEntity(Long adminId, String adminName, String adminContact) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminContact = adminContact;
	}

	/**
	 * getter and setter	
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

	public List<AdmissionEntity> getAdmissionResult() {
		return admissionResult;
	}

	public void setAdmissionResult(List<AdmissionEntity> admissionResult) {
		this.admissionResult = admissionResult;
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
		result = prime * result + ((admissionResult == null) ? 0 : admissionResult.hashCode());
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
		AdmissionCommiteeMemberEntity other = (AdmissionCommiteeMemberEntity) obj;
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
		if (admissionResult == null) {
			if (other.admissionResult != null)
				return false;
		} else if (!admissionResult.equals(other.admissionResult))
			return false;
		return true;
	}
		
	/**
	 * corresponding toString() method
	 */	
	@Override
	public String toString() {
		return String.format("AdmissionCommiteeMemberEntity [adminId=%s, adminName=%s, adminContact=%s]", adminId,
				adminName, adminContact);
	}

}
