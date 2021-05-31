package com.cg.ucaa.models;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * This is a Model Class
 * 
 * @author Akshat Kumar
 *
 */
public class LoginModel {

	/**
	 * primary key
	 */
	@NotNull(message = "login Id cannot be null")
	private Long loginId;
	
	/**
	 * first name cannot be null/blank
	 **/
	@NotNull(message = "first name cannot be null")
	@NotBlank(message = "first name cannot be blank")
	private String firstName;
	
	/**
	 * last name cannot be null/blank
	 **/
	@NotNull(message = "last name cannot be null")
	@NotBlank(message = "last name cannot be blank")
	private String lastName;
	
	/**
	 * email cannot be null/blank
	 **/
	@NotNull(message = "email cannot be null")
	@NotBlank(message = "email cannot be blank")
	private String email;
	
	/**
	 * password cannot be null/blank
	 **/
	@NotNull(message = "password cannot be null")
	@NotBlank(message = "password cannot be blank")
	private String password;
	
	/**
	 * mobile number cannot be null/blank
	 **/
	@NotNull(message = "mobile number cannot be null")
	@NotBlank(message = "mobile number cannot be blank")
	private String mobileNumber;
	
	/**
	 * address cannot be null/blank
	 **/
	@NotNull(message = "address cannot be null")
	@NotBlank(message = "address cannot be blank")
	private String address;
	
	/**
	 * postal code cannot be null/blank
	 **/
	@NotNull(message = "postal code cannot be null")
	@NotBlank(message = "postal code cannot be blank")
	private String postalCode;
	
	
	/**
	 * default constructor
	 **/
	public LoginModel() {
		/* no implementation */
	}

	/**
	 * parameterized constructor
	 **/
	public LoginModel(@NotNull(message = "login Id cannot be null") Long loginId,
			@NotNull(message = "first name cannot be null") @NotBlank(message = "first name cannot be blank") String firstName,
			@NotNull(message = "last name cannot be null") @NotBlank(message = "last name cannot be blank") String lastName,
			@NotNull(message = "email cannot be null") @NotBlank(message = "email cannot be blank") String email,
			@NotNull(message = "password cannot be null") @NotBlank(message = "password cannot be blank") String password,
			@NotNull(message = "mobile number cannot be null") @NotBlank(message = "mobile number cannot be blank") String mobileNumber,
			@NotNull(message = "address cannot be null") @NotBlank(message = "address cannot be blank") String address,
			@NotNull(message = "postal code cannot be null") @NotBlank(message = "postal code cannot be blank") String postalCode) {
		super();
		this.loginId = loginId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.postalCode = postalCode;
	}  

	public LoginModel(
			@NotNull(message = "email cannot be null") @NotBlank(message = "email cannot be blank") String email,
			@NotNull(message = "password cannot be null") @NotBlank(message = "password cannot be blank") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	/**
	 * corresponding getters and setters
	 **/
	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}	

	/**
	 * over-riding equals and hashCode() methods
	 **/
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result + ((mobileNumber == null) ? 0 : mobileNumber.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((postalCode == null) ? 0 : postalCode.hashCode());
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
		LoginModel other = (LoginModel) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (mobileNumber == null) {
			if (other.mobileNumber != null)
				return false;
		} else if (!mobileNumber.equals(other.mobileNumber))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		return true;
	}

	/**
	 * corresponding toString() method
	 **/
	@Override
	public String toString() {
		return String.format(
				"LoginModel [loginId=%s, firstName=%s, lastName=%s, email=%s, password=%s, mobileNumber=%s, address=%s, postalCode=%s]",
				loginId, firstName, lastName, email, password, mobileNumber, address, postalCode);
	}
	
}