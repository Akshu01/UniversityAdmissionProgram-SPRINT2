package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ucaa.entities.ApplicantEntity;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.repository.IApplicantRepository;

@Service
public class EMParserApplicant {

	@Autowired
	private IApplicantRepository applicantRepo;
	
	
	/**
	 * default constructor
	 */
	public EMParserApplicant() {
		super();
	}
	
	/**
	 * parameterized constructor
	 * @param applicantRepo
	 */
	public EMParserApplicant(IApplicantRepository applicantRepo) {
		super();
		this.applicantRepo = applicantRepo;
	}

	public ApplicantModel parse(ApplicantEntity source) {
		return source == null ? null
				: new ApplicantModel(source.getApplicantId().longValue(), source.getApplicantName(),
						source.getMobileNumber(), source.getApplicantDegree(), source.getApplicantGradPercent());
	}

	public ApplicantEntity parse(ApplicantModel source) {
		return source == null ? null
				: new ApplicantEntity(Long.valueOf(source.getApplicantId()), source.getApplicantName(),
						source.getMobileNumber(), source.getApplicantDegree(), source.getApplicantGradPercent());
	}
}
