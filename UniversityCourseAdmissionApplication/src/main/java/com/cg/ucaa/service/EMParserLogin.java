package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ucaa.entities.LoginEntity;
import com.cg.ucaa.models.LoginModel;
import com.cg.ucaa.repository.IUniversityStaffMemberRepository;

/**
 * This is a parser class to facilitate details to end user
 * @author Akshat Kumar
 *
 */
@Service
public class EMParserLogin {

	@Autowired
	private IUniversityStaffMemberRepository loginRepo;
	
	/**
	 * default constructor
	 */
	public EMParserLogin() {
		super();
	}
	
	/**
	 * parameterized constructor
	 * @param loginRepo
	 */
	public EMParserLogin(IUniversityStaffMemberRepository loginRepo) {
		super();
		this.loginRepo = loginRepo;
	}

	public LoginEntity parse(LoginModel source) {
		return source == null ? null
				: new LoginEntity(source.getLoginId(), source.getFirstName(), source.getLastName(), source.getEmail(), 
						source.getPassword(), source.getMobileNumber(), source.getAddress(), source.getPostalCode());
	}

	public LoginModel parse(LoginEntity source) {
		return source == null ? null
				: new LoginModel(source.getLoginId(), source.getFirstName(), source.getLastName(), source.getEmail(), 
						source.getPassword(), source.getMobileNumber(), source.getAddress(), source.getPostalCode());
	}

}
