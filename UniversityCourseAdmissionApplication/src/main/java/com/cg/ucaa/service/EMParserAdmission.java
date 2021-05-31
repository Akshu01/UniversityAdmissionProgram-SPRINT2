package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ucaa.entities.AdmissionEntity;
import com.cg.ucaa.models.AdmissionModel;
import com.cg.ucaa.repository.IAdmissionCommiteeMemberRepository;
import com.cg.ucaa.repository.IAdmissionRepository;
import com.cg.ucaa.repository.IApplicantRepository;
import com.cg.ucaa.repository.ICourseRepository;

@Service
public class EMParserAdmission {

	@Autowired
	private IAdmissionRepository admissionRepo;
	
	@Autowired
	private ICourseRepository courseRepo;
	
	@Autowired
	private IApplicantRepository applicantRepo;
	
	@Autowired
	private IAdmissionCommiteeMemberRepository adminRepo;
	
	@Autowired
	private EMParserApplicant parser;
	
	@Autowired
	private EMParserCourse parserCourse;
	
	@Autowired
	private EMParserAdmissionCommiteeMember parserCommitee;

	public EMParserAdmission() {
		super();
		this.parser = new EMParserApplicant();
		this.parserCourse = new EMParserCourse();
		this.parserCommitee = new EMParserAdmissionCommiteeMember();
	}

	public EMParserAdmission(IAdmissionRepository admissionRepo, ICourseRepository courseRepo,
			IApplicantRepository applicantRepo, IAdmissionCommiteeMemberRepository adminRepo) {
		super();
		this.admissionRepo = admissionRepo;
		this.courseRepo = courseRepo;
		this.applicantRepo = applicantRepo;
		this.adminRepo = adminRepo;
		this.parser = new EMParserApplicant();
		this.parserCourse = new EMParserCourse();
		this.parserCommitee = new EMParserAdmissionCommiteeMember();
	}

	public AdmissionModel parse(AdmissionEntity source) {
		return source == null ? null
				: new AdmissionModel(source.getAdmissionId().longValue(),
						source.getAdmissionDate(),
						source.getAdmissionStatus(),
						source.getCourse().getCourseId(),
						source.getApplicant().getApplicantId(),
						source.getAdmissionComMember().getAdminId());
	}

	public AdmissionEntity parse(AdmissionModel source) {
		return source == null ? null
				: new AdmissionEntity(source.getAdmissionId().longValue(),
						source.getAdmissionDate(),
						source.getAdmissionStatus(),
						courseRepo.findById(source.getCourseId()).orElse(null),
						applicantRepo.findById(source.getApplicantId()).orElse(null),
						adminRepo.findById(source.getAdminId()).orElse(null));
	}
}
