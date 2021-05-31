 package com.cg.ucaa.service;

import com.cg.ucaa.exception.AdmissionCommiteeMemberNotFoundException;
import com.cg.ucaa.exception.ApplicantNotFoundException;
import com.cg.ucaa.exception.LoginFailedException;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.models.LoginModel;

/**
 * This is a service layer
 * @author Akshat Kumar
 *
 */
public interface ILoginService {

	public LoginModel signUp(LoginModel data) throws LoginFailedException;
	public LoginModel loginApplicant(String email,String password) throws LoginFailedException;
	public AdmissionCommiteeMemberModel loginAdmin(String name, String number) throws AdmissionCommiteeMemberNotFoundException;
	public AdmissionCommiteeMemberModel signupAdmin(AdmissionCommiteeMemberModel admin) throws AdmissionCommiteeMemberNotFoundException;
	public ApplicantModel registerApplicant(ApplicantModel applicant) throws ApplicantNotFoundException;
}
