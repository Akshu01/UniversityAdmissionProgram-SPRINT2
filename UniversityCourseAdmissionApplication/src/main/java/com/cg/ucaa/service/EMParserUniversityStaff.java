package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ucaa.entities.UniversityStaffMemberEntity;
import com.cg.ucaa.models.UniversityStaffMemberModel;
import com.cg.ucaa.repository.IUniversityStaffMemberRepository;

/**
 * This is a parser class to facilitate details to end user
 * @author Akshat Kumar
 *
 */
@Service
public class EMParserUniversityStaff {

	@Autowired
	private IUniversityStaffMemberRepository staffRepo;
	
	/**
	 * default constructor
	 */
	public EMParserUniversityStaff() {
		super();
	}
	
	/**
	 * parameterized constructor
	 * @param staffRepo
	 */
	public EMParserUniversityStaff(IUniversityStaffMemberRepository staffRepo) {
		super();
		this.staffRepo = staffRepo;
	}

	public UniversityStaffMemberEntity parse(UniversityStaffMemberModel source) {
		return source == null ? null
				: new UniversityStaffMemberEntity(source.getStaffId(), source.getPassword(), source.getRole());
	}

	public UniversityStaffMemberModel parse(UniversityStaffMemberEntity source) {
		return source == null ? null
				: new UniversityStaffMemberModel(source.getStaffId(), source.getPassword(), source.getRole());
	}

}
