package com.cg.ucaa.service;

import java.util.List;

import com.cg.ucaa.exception.AdmissionCommiteeMemberNotFoundException;
import com.cg.ucaa.exception.AdmissionNotGrantedException;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.models.AdmissionModel;

public interface IAdmissionCommiteeMemberService {
	
	AdmissionCommiteeMemberModel addCommiteeMember(AdmissionCommiteeMemberModel AdmissionCommiteeMember) throws AdmissionCommiteeMemberNotFoundException;
	AdmissionCommiteeMemberModel updateCommiteeMember(AdmissionCommiteeMemberModel AdmissionCommiteeMember) throws AdmissionCommiteeMemberNotFoundException;
	boolean	removeCommiteeMember(Long adminid) throws AdmissionCommiteeMemberNotFoundException;
	AdmissionCommiteeMemberModel viewCommiteeMember(Long adminid) throws AdmissionCommiteeMemberNotFoundException;
	List<AdmissionCommiteeMemberModel> viewAllCommiteeMembers() throws AdmissionCommiteeMemberNotFoundException;
	AdmissionModel viewByAdmissionId(Long admissionId) throws AdmissionNotGrantedException;
}