package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ucaa.exception.AdmissionCommiteeMemberNotFoundException;
import com.cg.ucaa.exception.ApplicantNotFoundException;
import com.cg.ucaa.exception.LoginFailedException;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.models.LoginModel;
import com.cg.ucaa.repository.IAdmissionCommiteeMemberRepository;
import com.cg.ucaa.repository.IApplicantRepository;
import com.cg.ucaa.repository.ILoginRepository;

/**
 * This is service implementation class 
 * @author Akshat Kumar
 *
 */
@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginRepository loginRepo;
	
	@Autowired
	private IAdmissionCommiteeMemberRepository admissionCommiteeMemberRepo;
	
	@Autowired
	private IApplicantRepository applicantRepo;

	@Autowired
	private EMParserLogin parser;
	
	@Autowired
	private EMParserAdmissionCommiteeMember parser1;
	
	@Autowired
	private EMParserApplicant parser2;
	
	/**
	 * default constructor
	 */
	public LoginServiceImpl() {

	}
	
	/**
	 * parameterized constructor
	 * @param loginRepo
	 */
	public LoginServiceImpl(ILoginRepository loginRepo, 
			IAdmissionCommiteeMemberRepository admissionCommiteeMemberRepo, IApplicantRepository applicantRepo) {
		super();
		this.loginRepo = loginRepo;
		this.admissionCommiteeMemberRepo = admissionCommiteeMemberRepo;
		this.applicantRepo = applicantRepo;
		this.parser = new EMParserLogin();
		this.parser1 = new EMParserAdmissionCommiteeMember();
		this.parser2 = new EMParserApplicant();
	}
	
	@Transactional
	@Override
	public LoginModel signUp(LoginModel data) throws LoginFailedException {
		if (data != null) {
			if (loginRepo.existsById(data.getLoginId())) {
				throw new LoginFailedException("Invalid Registration Data");
			}

			data = parser.parse(loginRepo.save(parser.parse(data)));
		}

		return data;
	}
	
	@Transactional
	@Override
	public LoginModel loginApplicant(String email,String password) throws LoginFailedException {
		LoginModel data =  parser.parse(loginRepo.findByEmailAndPassword(email, password));
		return data;
	}

	@Override
	public AdmissionCommiteeMemberModel loginAdmin(String name, String number)
			throws AdmissionCommiteeMemberNotFoundException {
		AdmissionCommiteeMemberModel admin = parser1.parse(admissionCommiteeMemberRepo.findByNameAndNumber(name, number));
		return admin;
	}

	@Override
	public AdmissionCommiteeMemberModel signupAdmin(AdmissionCommiteeMemberModel admin)
			throws AdmissionCommiteeMemberNotFoundException {
		if(admin != null) {
			if(admissionCommiteeMemberRepo.existsById(admin.getAdminId())) {
				throw new AdmissionCommiteeMemberNotFoundException("Admin Id "+ admin.getAdminId() + " exists already.");
			} else {
				admin = parser1.parse(admissionCommiteeMemberRepo.save(parser1.parse(admin)));
			}
		}
		return admin;
	}

	@Override
	public ApplicantModel registerApplicant(ApplicantModel applicant) throws ApplicantNotFoundException {
		if (applicant != null) {
			if (applicantRepo.existsById(applicant.getApplicantId())) {
				throw new ApplicantNotFoundException("Applicant Id " + applicant.getApplicantId() + " exists already.");
			} else {
				applicant = parser2.parse(applicantRepo.save(parser2.parse(applicant)));
			}
		}
		return applicant;
	}
		
}
