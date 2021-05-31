package com.cg.ucaa.service;

import java.util.List;

import com.cg.ucaa.exception.CourseNotFoundException;
import com.cg.ucaa.models.CourseModel;

/**
 * This is a service layer
 */
public interface ICourseService {
	public CourseModel addCourse(CourseModel course) throws CourseNotFoundException;

	public boolean removeCourse(Long courseId) throws CourseNotFoundException;

	public CourseModel updateCourse(CourseModel course) throws CourseNotFoundException;

	public CourseModel viewCourse(Long courseid) throws CourseNotFoundException;

	public List<CourseModel> viewAllCourses();
}
