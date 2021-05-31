package com.cg.ucaa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ucaa.entities.CourseEntity;
import com.cg.ucaa.models.CourseModel;
import com.cg.ucaa.repository.ICourseRepository;
import com.cg.ucaa.repository.IUniversityStaffMemberRepository;

/**
 * This is a parser class to facilitate details to end user
 *
 */
@Service
public class EMParserCourse {
	
	@Autowired
	private ICourseRepository courseRepo;
	
	@Autowired
	private IUniversityStaffMemberRepository staffRepo;
	
	@Autowired
	private EMParserUniversityStaff parser;
	/**
	 * default constructor
	 */
	public EMParserCourse() {
		super();
		this.parser = new EMParserUniversityStaff();
	}
	
	/**
	 * parameterized constructor
	 * @param courseRepo
	 */
	public EMParserCourse(ICourseRepository courseRepo, IUniversityStaffMemberRepository staffRepo) {
		super();
		this.courseRepo = courseRepo;
		this.staffRepo = staffRepo;
		this.parser = new EMParserUniversityStaff();
	}

	public CourseEntity parse(CourseModel source) {
		return source == null ? null
				: new CourseEntity(source.getCourseId(),source.getCourseName(),source.getCourseDuration(),source.getCourseStartDate(),
					source.getCourseEndDate(),source.getCourseFees(),staffRepo.findById(source.getStaff_id()).orElse(null));
	}
	
	public CourseModel parse(CourseEntity source) {
		return source == null ? null
				: new CourseModel(source.getCourseId(),source.getCourseName(),source.getCourseDuration(),source.getCourseStartDate(),
					source.getCourseEndDate(),source.getCourseFees(),source.getUniversityStaffMember().getStaffId());
	}
	
}