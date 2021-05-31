package com.cg.ucaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ucaa.exception.ApplicantNotFoundException;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.service.IApplicantService;

@RestController
@CrossOrigin
@RequestMapping(path = "/applicants")
public class ApplicantRestController {

	@Autowired
	private IApplicantService applicantService;

	/**
	 * Fetching applicant by applicant id
	 * @param applicantId
	 * @return Applicant
	 * @throws ApplicantNotFoundException
	 */	
	@GetMapping("/{applicantId}")
	public ResponseEntity<ApplicantModel> viewApplicant(@PathVariable("applicantId") Long applicantId)throws ApplicantNotFoundException {
		ResponseEntity<ApplicantModel> response = null;
		ApplicantModel applicant = applicantService.viewApplicant(applicantId);
		if(applicant == null) {
			response = new ResponseEntity<>(applicant,HttpStatus.NOT_FOUND);
		} else {
			response = new ResponseEntity<>(applicant,HttpStatus.OK);
		}
		return response;
	}	

	/**
	 * Fetching all applicants
	 * @return List<Applicant>
	 */	
	@GetMapping
	public ResponseEntity<List<ApplicantModel>> viewAllApplicants()
			throws ApplicantNotFoundException {
		return new ResponseEntity<>(applicantService.viewAllApplicants(), HttpStatus.OK);

	}

	/**
	 * Deleting applicant by applicant id
	 * @param applicantId
	 * @throws ApplicantNotFoundException
	 */	
	@DeleteMapping("/{ApplicantId}")
	public ResponseEntity<Boolean> removeApplicant(@PathVariable("ApplicantId") Long applicantId)
			throws ApplicantNotFoundException {
		Boolean result = applicantService.removeApplicant(applicantId);
		ResponseEntity<Boolean> response = new ResponseEntity<Boolean>(result, HttpStatus.OK);
		return response;
	}
	
	/**
	 * Updating applicant details in applicant
	 * @return updated Applicant
	 * @throws ApplicantNotFoundException
	 */
	@PutMapping
	public ResponseEntity<ApplicantModel> updateApplicant(@RequestBody ApplicantModel applicant) throws ApplicantNotFoundException {
		return new ResponseEntity<ApplicantModel>(applicantService.updateApplicant(applicant),HttpStatus.OK);
	}
	
	/**
	 * Adding new applicant 
	 * @return Admission
	 * @throws ApplicantNotFoundException
	 */
	@PostMapping
	public ResponseEntity<ApplicantModel> addApplicant(@RequestBody ApplicantModel applicant) throws ApplicantNotFoundException {
		return new ResponseEntity<ApplicantModel>(applicantService.registerApplicant(applicant), HttpStatus.OK);
	}
	
	
}