package com.cg.ucaa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ucaa.entities.AdmissionCommiteeMemberEntity;
import com.cg.ucaa.entities.AdmissionEntity;
import com.cg.ucaa.exception.AdmissionCommiteeMemberNotFoundException;
import com.cg.ucaa.exception.AdmissionNotGrantedException;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.models.AdmissionModel;
import com.cg.ucaa.repository.IAdmissionCommiteeMemberRepository;
import com.cg.ucaa.repository.IAdmissionRepository;

@Service
public class AdmissionCommiteeMemberServiceImpl implements IAdmissionCommiteeMemberService {

	@Autowired
	private IAdmissionCommiteeMemberRepository admissionCommiteeMemberRepo;
	
	@Autowired
	private IAdmissionRepository admissionRepo;
	
	@Autowired
	private EMParserAdmissionCommiteeMember parser;
	
	@Autowired
	private EMParserAdmission parser1;
	
	public AdmissionCommiteeMemberServiceImpl() {
		}
	
	public AdmissionCommiteeMemberServiceImpl(IAdmissionCommiteeMemberRepository admissionCommiteeMemberRepo) {
		this.admissionCommiteeMemberRepo = admissionCommiteeMemberRepo;
		this.parser = new EMParserAdmissionCommiteeMember();
	}
	
	/**
	 * service implementation for adding a commitee member to repository
	 **/
	@Transactional
	@Override
	public AdmissionCommiteeMemberModel addCommiteeMember(AdmissionCommiteeMemberModel admissionCommiteeMember)
			throws AdmissionCommiteeMemberNotFoundException {
		if(admissionCommiteeMember != null) {
			if(admissionCommiteeMemberRepo.existsById(admissionCommiteeMember.getAdminId())) {
				throw new AdmissionCommiteeMemberNotFoundException("Admin Id "+ admissionCommiteeMember.getAdminId() + " exists already.");
			} else {
				admissionCommiteeMember = parser.parse(admissionCommiteeMemberRepo.save(parser.parse(admissionCommiteeMember)));
			}
		}
		return admissionCommiteeMember;
	}

	/**
	 * service implementation for updating details of a commitee member in repository
	 **/	
	@Transactional
	@Override
	public AdmissionCommiteeMemberModel updateCommiteeMember(AdmissionCommiteeMemberModel admissionCommiteeMember)
			throws AdmissionCommiteeMemberNotFoundException {
		if ( admissionCommiteeMember!= null) {
			if (!admissionCommiteeMemberRepo.existsById(admissionCommiteeMember.getAdminId())) {
				throw new AdmissionCommiteeMemberNotFoundException("No Such Member");
			}

			admissionCommiteeMember = parser.parse(admissionCommiteeMemberRepo.save(parser.parse(admissionCommiteeMember)));		}
		return admissionCommiteeMember;
	}

	/**
	 * service implementation for removing a commitee member from repository
	 **/	
	@Transactional
	@Override
	public boolean removeCommiteeMember(Long adminid) throws AdmissionCommiteeMemberNotFoundException {
		AdmissionCommiteeMemberEntity newadmin = admissionCommiteeMemberRepo.findById(adminid).orElse(null);
		boolean bool = false;
		if (newadmin == null) {
			throw new AdmissionCommiteeMemberNotFoundException("No staff with id #" + adminid + " present");
		} else {
			admissionCommiteeMemberRepo.deleteById(adminid);
			bool = true;
		}
		return bool;
	}
	
	
	/**
	 * service implementation for viewing a commitee member in repository
	 **/	
	@Transactional
	@Override
	public AdmissionCommiteeMemberModel viewCommiteeMember(Long adminid)
			throws AdmissionCommiteeMemberNotFoundException {
		return parser.parse(admissionCommiteeMemberRepo.findById(adminid).orElse(null));

	}
	
	/**
	 * service implementation for viewing all commitee members in repository
	 **/	
	@Transactional
	@Override
	public List<AdmissionCommiteeMemberModel> viewAllCommiteeMembers() throws AdmissionCommiteeMemberNotFoundException {
		return admissionCommiteeMemberRepo.findAll().stream().map(admission -> parser.parse(admission)).collect(Collectors.toList());
	}

	/**
	 * service implementation for viewing a admission detail in repository
	 **/
	
	@Override
	public AdmissionModel viewByAdmissionId(Long admissionId) throws AdmissionNotGrantedException {
		AdmissionEntity admission = admissionRepo.findById(admissionId).orElse(null);
		if (admission == null) {
			throw new AdmissionNotGrantedException("Admission with id "+ admissionId +"doesn't exists");
		} else
			return parser1.parse(admissionRepo.findById(admissionId).get());
	}
	
}