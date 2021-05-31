package com.cg.ucaa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ucaa.entities.AdmissionEntity;
import com.cg.ucaa.exception.AdmissionNotGrantedException;
import com.cg.ucaa.models.AdmissionModel;
import com.cg.ucaa.repository.IAdmissionRepository;

//service layer implementation class
@Service
public class AdmissionServiceImpl implements IAdmissionService{
	
	@Autowired
	private IAdmissionRepository admissionRepo;
	
	@Autowired
	private EMParserAdmission parser;
	
	public AdmissionServiceImpl() {
		//default constructor
		//no implementation
	}
	
	//parameterized constructor
	public AdmissionServiceImpl(IAdmissionRepository admissionRepo) {
		super();
		this.admissionRepo = admissionRepo;
		this.parser = new EMParserAdmission();
	}
	
	/*
	 * to add a new admission
	 * param: Admission Model
	 * return: Admission Model
	 * @throws AdmissionNotGrantedException
	 * */
	@Transactional
	@Override
	public AdmissionModel addAdmission(AdmissionModel admission) throws AdmissionNotGrantedException {
		if(admission != null) {
			if(admissionRepo.existsById(admission.getAdmissionId())) {
				throw new AdmissionNotGrantedException("Admission Id "+ admission.getAdmissionId() + " exists already.");
			}else {
				admission = parser.parse(admissionRepo.save(parser.parse(admission)));
			}
		} 
		
		return admission;
	}
	
	/*
	 * to update existing admission
	 *  param: Admission Model
	 * return: updated Admission Model
	 * @throws AdmissionNotGrantedException
	 * */
	@Transactional
	@Override
	public AdmissionModel updateAdmission(AdmissionModel admission) throws AdmissionNotGrantedException {
		AdmissionEntity oldAdmission = admissionRepo.findById(admission.getAdmissionId()).orElse(null);
		if ( oldAdmission == null) {
			throw new AdmissionNotGrantedException("No admission with id #" + admission.getAdmissionId() + " present");
		} else {
			admission = parser.parse(admissionRepo.save(parser.parse(admission)));
		}
		return admission;

	}
	
	/*
	 * to delete an admission
	 * param: admissionId
	 * @throws AdmissionNotGrantedException
	 * */
	@Transactional
	@Override
	public boolean removeAdmission(Long admissionId) throws AdmissionNotGrantedException {
		boolean result = false;
		AdmissionEntity oldAdmission = admissionRepo.findById(admissionId).orElse(null);
		if (oldAdmission == null) {
			throw new AdmissionNotGrantedException("No admission with id #" + admissionId + " present");
		} else {
			admissionRepo.deleteById(admissionId);
			result = true;
		}
		return result;
	}
	
	/*
	 * view admission details by giving admissionId
	 * param: admissionId
	 * return: AdmissionModel
	 * @throws AdmissionNotGrantedException*/
	@Override
	public AdmissionModel viewByAdmissionId(Long admissionId) throws AdmissionNotGrantedException {
		AdmissionEntity admission = admissionRepo.findById(admissionId).orElse(null);
		if (admission == null) {
			throw new AdmissionNotGrantedException("Admission with id "+ admissionId +"doesn't exists");
		} else
			return parser.parse(admissionRepo.findById(admissionId).get());
	}

	/*
	 * to view all admissions
	 * */
	@Override
	public List<AdmissionModel> viewAllAdmissions() {
		 return admissionRepo.findAll().stream().map(admission -> parser.parse(admission)).collect(Collectors.toList());
	}

}
