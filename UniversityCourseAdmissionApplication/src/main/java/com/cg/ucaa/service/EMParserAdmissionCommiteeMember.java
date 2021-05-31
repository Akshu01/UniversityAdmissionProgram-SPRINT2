package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ucaa.entities.AdmissionCommiteeMemberEntity;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.repository.IAdmissionCommiteeMemberRepository;

@Service
public class EMParserAdmissionCommiteeMember {

	@Autowired
	private IAdmissionCommiteeMemberRepository admissionCommiteeMemberRepo;
	
	/**
	 * default constructor
	 */
	public EMParserAdmissionCommiteeMember() {
		super();
	}
	
	/**
	 * parameterized constructor
	 * @param admissionCommiteeMemberRepo
	 */
	public EMParserAdmissionCommiteeMember(IAdmissionCommiteeMemberRepository admissionCommiteeMemberRepo) {
		super();
		this.admissionCommiteeMemberRepo = admissionCommiteeMemberRepo;
	}

	public AdmissionCommiteeMemberModel parse(AdmissionCommiteeMemberEntity source) {
		return source == null ? null
				: new AdmissionCommiteeMemberModel(source.getAdminId().longValue(), source.getAdminName(),
						source.getAdminContact());
	}

	public AdmissionCommiteeMemberEntity parse(AdmissionCommiteeMemberModel source) {
		return source == null ? null
				: new AdmissionCommiteeMemberEntity(Long.valueOf(source.getAdminId()), source.getAdminName(),
						source.getAdminContact());
	}
}
