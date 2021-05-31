package com.cg.ucaa.service;

import java.util.List;

import com.cg.ucaa.exception.CourseNotFoundException;
import com.cg.ucaa.exception.UniversityStaffMemberNotFoundException;
import com.cg.ucaa.models.CourseModel;
import com.cg.ucaa.models.UniversityStaffMemberModel;

/**
 * This is a service layer
 * @author Akshat Kumar
 *
 */
public interface IUniversityStaffService {
	
	public UniversityStaffMemberModel addStaff(UniversityStaffMemberModel user) throws UniversityStaffMemberNotFoundException;

	public UniversityStaffMemberModel updateStaff(UniversityStaffMemberModel user) throws UniversityStaffMemberNotFoundException;

	public UniversityStaffMemberModel viewStaff(Long staffid) throws UniversityStaffMemberNotFoundException;

	public boolean removeStaff(Long staffid) throws UniversityStaffMemberNotFoundException;

	public List<UniversityStaffMemberModel> viewAllStaffs();

	public CourseModel addCourse(CourseModel course) throws CourseNotFoundException;

	public boolean removeCourse(Long courseId) throws CourseNotFoundException;

	public CourseModel updateCourse(CourseModel course) throws CourseNotFoundException;

}
