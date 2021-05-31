package com.cg.ucaa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ucaa.entities.ApplicantEntity;
import com.cg.ucaa.exception.ApplicantNotFoundException;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.repository.IApplicantRepository;

@Service
public class ApplicantServiceImpl implements IApplicantService {
	@Autowired
	private IApplicantRepository applicantRepo;

	@Autowired
	private EMParserApplicant parser;

	public ApplicantServiceImpl() {
		this.parser = new EMParserApplicant();
	}

	/**
	 * service implementation for adding a applicant to repository
	 **/
	@Transactional
	@Override
	public ApplicantModel registerApplicant(ApplicantModel applicant) throws ApplicantNotFoundException {
		if (applicant != null) {
			if (applicantRepo.existsById(applicant.getApplicantId())) {
				throw new ApplicantNotFoundException("Applicant Id " + applicant.getApplicantId() + " exists already.");
			} else {
				applicant = parser.parse(applicantRepo.save(parser.parse(applicant)));
			}
		}
		return applicant;
	}

	/**
	 * service implementation for updating details of a applicant in repository
	 **/
	@Transactional
	@Override
	public ApplicantModel updateApplicant(ApplicantModel applicant) throws ApplicantNotFoundException {
		if (applicant != null) {
			if (!applicantRepo.existsById(applicant.getApplicantId())) {
				throw new ApplicantNotFoundException("No Such applicant found");
			}

			applicant = parser.parse(applicantRepo.save(parser.parse(applicant)));
		}
		return applicant;
	}

	/**
	 * service implementation for removing a applicant from repository
	 **/
	@Transactional
	@Override
	public boolean removeApplicant(Long applicantId) throws ApplicantNotFoundException {
		ApplicantEntity oldApplicant = applicantRepo.findById(applicantId).orElse(null);
		boolean result = false;
		if (oldApplicant == null) {
			throw new ApplicantNotFoundException("No applicant with id #" + applicantId + " present");
		} else {
			applicantRepo.deleteById(applicantId);
			result = true;
		}
		return result;
	}

	/**
	 * service implementation for viewing a applicant in repository
	 **/
	@Transactional
	@Override
	public ApplicantModel viewApplicant(Long applicantId) {
		return parser.parse(applicantRepo.findById(applicantId).orElse(null));
	}

	/**
	 * service implementation for viewing all applicants in repository
	 **/
	@Transactional
	@Override
	public List<ApplicantModel> viewAllApplicants() {
		return applicantRepo.findAll().stream().map(course -> parser.parse(course))
				.collect(Collectors.toList());
	}

}
