package com.cg.ucaa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ucaa.entities.CourseEntity;
import com.cg.ucaa.entities.UniversityStaffMemberEntity;
import com.cg.ucaa.exception.CourseNotFoundException;
import com.cg.ucaa.exception.UniversityStaffMemberNotFoundException;
import com.cg.ucaa.models.CourseModel;
import com.cg.ucaa.models.UniversityStaffMemberModel;
import com.cg.ucaa.repository.ICourseRepository;
import com.cg.ucaa.repository.IUniversityStaffMemberRepository;

/**
 * This is service implementation class 
 * @author Akshat Kumar
 *
 */
@Service
public class UniversityStaffMemberImpl implements IUniversityStaffService {


	@Autowired
	private IUniversityStaffMemberRepository staffRepo;
	
	@Autowired
	private ICourseRepository courseRepo;

	@Autowired
	private EMParserUniversityStaff parser;
	
	@Autowired
	private EMParserCourse parserCourse;
	
	/**
	 * default constructor
	 */
	public UniversityStaffMemberImpl() {

	}
	
	/**
	 * parameterized constructor
	 * @param staffRepo
	 * @param courseRepo
	 */
	public UniversityStaffMemberImpl(IUniversityStaffMemberRepository staffRepo,ICourseRepository courseRepo) {
		super();
		this.staffRepo = staffRepo;
		this.courseRepo = courseRepo;
		this.parser = new EMParserUniversityStaff();
		this.parserCourse = new EMParserCourse();
	}
	
	/**
	 * service implementation for adding a staff to repository
	 **/
	@Transactional
	@Override
	public UniversityStaffMemberModel addStaff(UniversityStaffMemberModel user)
			throws UniversityStaffMemberNotFoundException {
		if (user != null) {
			if (staffRepo.existsById(user.getStaffId())) {
				throw new UniversityStaffMemberNotFoundException("Staff with this id already exists");
			}

			user = parser.parse(staffRepo.save(parser.parse(user)));
		}

		return user;
	}
	
	/**
	 * service implementation for updating details of a staff in repository
	 **/
	@Transactional
	@Override
	public UniversityStaffMemberModel updateStaff(UniversityStaffMemberModel user)
			throws UniversityStaffMemberNotFoundException {
		if (user != null) {
			if (!staffRepo.existsById(user.getStaffId())) {
				throw new UniversityStaffMemberNotFoundException("No Such Staff Member");
			}

			user = parser.parse(staffRepo.save(parser.parse(user)));
		}
		return user;

	}
	
	/**
	 * service implementation for viewing a staff in repository
	 **/
	@Transactional
	@Override
	public UniversityStaffMemberModel viewStaff(Long staffid) throws UniversityStaffMemberNotFoundException {
		UniversityStaffMemberEntity existingStaff = staffRepo.findById(staffid).orElse(null);
		if (existingStaff == null) {
			throw new UniversityStaffMemberNotFoundException("staff with id doesn't exists");
		} else
			return parser.parse(staffRepo.findById(staffid).get());
	}
	
	/**
	 * service implementation for removing a staff from repository
	 **/
	@Transactional
	@Override
	public boolean removeStaff(Long staffid) throws UniversityStaffMemberNotFoundException {
		UniversityStaffMemberEntity existingStaff = staffRepo.findById(staffid).orElse(null);
		boolean result = false;
		if (existingStaff == null) {
			throw new UniversityStaffMemberNotFoundException("No staff with id #" + staffid + " present");
		} else {
			staffRepo.deleteById(staffid);
			result = true;
		}
		return result;
	}
	
	/**
	 * service implementation for viewing all staffs in repository
	 **/
	@Transactional
	@Override
	public List<UniversityStaffMemberModel> viewAllStaffs() {
		return  staffRepo.findAll().stream().map(member -> parser.parse(member))
				.collect(Collectors.toList());
		
	}
	
	/**
	 * service implementation for adding a course to repository
	 **/
	@Transactional
	@Override
	public CourseModel addCourse(CourseModel course) throws CourseNotFoundException {
		if (course != null) {
			if (courseRepo.existsById(course.getCourseId())) {
				throw new CourseNotFoundException("Course with this id already exists");
			}

			course = parserCourse.parse(courseRepo.save(parserCourse.parse(course)));
		}

		return course;
	}
	
	/**
	 * service implementation for removing a course from repository
	 **/
	@Transactional
	@Override
	public boolean removeCourse(Long courseId) throws CourseNotFoundException {
		CourseEntity oldCourse = courseRepo.findById(courseId).orElse(null);
		if (oldCourse == null) {
			throw new CourseNotFoundException("No course with id #" + courseId + " present");
		} else {
			courseRepo.deleteById(courseId);
			return true;
		}

	}
	
	/**
	 * service implementation for updating details of a course in repository
	 **/
	@Transactional
	@Override
	public CourseModel updateCourse(CourseModel course) throws CourseNotFoundException {
		if (course != null) {
			if (!courseRepo.existsById(course.getCourseId())) {
				throw new CourseNotFoundException("No Such Course Present");
			}

			course = parserCourse.parse(courseRepo.save(parserCourse.parse(course)));
		}

		return course;
	}

}
