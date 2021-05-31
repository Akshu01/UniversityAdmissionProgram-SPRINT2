package com.cg.ucaa.service;

import java.util.List;

import com.cg.ucaa.exception.AdmissionNotGrantedException;
import com.cg.ucaa.models.AdmissionModel;

public interface IAdmissionService {
	AdmissionModel addAdmission(AdmissionModel admission) throws AdmissionNotGrantedException;
	AdmissionModel updateAdmission(AdmissionModel admission) throws AdmissionNotGrantedException;
	boolean removeAdmission(Long admissionId) throws AdmissionNotGrantedException;
	
	AdmissionModel viewByAdmissionId(Long admissionId) throws AdmissionNotGrantedException;
	List<AdmissionModel> viewAllAdmissions();
}