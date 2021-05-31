package com.cg.ucaa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ucaa.exception.AdmissionCommiteeMemberNotFoundException;
import com.cg.ucaa.exception.ApplicantNotFoundException;
import com.cg.ucaa.exception.LoginFailedException;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.models.LoginModel;
import com.cg.ucaa.service.IAdmissionCommiteeMemberService;
import com.cg.ucaa.service.IApplicantService;
import com.cg.ucaa.service.ILoginService;

/**
 * Controller class to facilitate operations
 * @author Akshat Kumar
 *
 */
@RestController
@CrossOrigin
@RequestMapping("/logins")
public class LoginRestController {

	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private IAdmissionCommiteeMemberService admissionCommiteeMemberService;
	
	@Autowired
	private IApplicantService applicantService;

	@PostMapping
	public ResponseEntity<LoginModel> addUser(@RequestBody LoginModel data)
			throws LoginFailedException {
		return new ResponseEntity<>(loginService.signUp(data), HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginModel> loginUser(@RequestBody LoginModel data)
			throws LoginFailedException {
		String tempEmail = data.getEmail();
		String tempPass = data.getPassword();
		LoginModel userObj = null;
		if(tempEmail != null && tempPass != null) {
			userObj = loginService.loginApplicant(tempEmail, tempPass);
		}
		if(userObj == null)
			throw new LoginFailedException("Invalid Credentials");
		
		return new ResponseEntity<>(userObj, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/addAdmin")
	public ResponseEntity<AdmissionCommiteeMemberModel> addAdmin(@RequestBody AdmissionCommiteeMemberModel admin)
			throws AdmissionCommiteeMemberNotFoundException {
		ResponseEntity<AdmissionCommiteeMemberModel> response = new ResponseEntity<AdmissionCommiteeMemberModel>(
				admissionCommiteeMemberService.addCommiteeMember(admin), HttpStatus.OK);

		return response;

	}
	
	@PostMapping("/addApplicant")
	public ResponseEntity<ApplicantModel> addApplicant(@RequestBody ApplicantModel applicant) throws ApplicantNotFoundException {
		return new ResponseEntity<ApplicantModel>(applicantService.registerApplicant(applicant), HttpStatus.OK);
	}
	
	@PostMapping("/loginAdmin")
	public ResponseEntity<AdmissionCommiteeMemberModel> loginAdmin(@RequestBody AdmissionCommiteeMemberModel data)
			throws AdmissionCommiteeMemberNotFoundException {
		String tempName = data.getAdminName();
		String tempContact = data.getAdminContact();
		AdmissionCommiteeMemberModel adminObj = null;
		if(tempName != null && tempContact != null) {
			adminObj = loginService.loginAdmin(tempName, tempContact);
		}
		if(adminObj == null)
			throw new AdmissionCommiteeMemberNotFoundException("Invalid Credentials");
		
		return new ResponseEntity<>(adminObj, HttpStatus.ACCEPTED);
	}
		
}