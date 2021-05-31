package com.cg.ucaa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.ucaa.entities.CourseEntity;
import com.cg.ucaa.exception.CourseNotFoundException;
import com.cg.ucaa.models.CourseModel;
import com.cg.ucaa.repository.ICourseRepository;

/**
 * This is service implementation class
 */
@Service
public class CourseServiceImpl implements ICourseService {

	@Autowired
	private ICourseRepository courseRepo;

	@Autowired
	private EMParserCourse parser;

	/**
	 * default constructor
	 */
	public CourseServiceImpl() {

	}

	/**
	 * 
	 * @param courseRepo
	 */
	public CourseServiceImpl(ICourseRepository courseRepo) {
		super();
		this.courseRepo = courseRepo;
		this.parser = new EMParserCourse();
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

			course = parser.parse(courseRepo.save(parser.parse(course)));
		}

		return course;
	}

	/**
	 * service implementation for removing a course from repository
	 **/
	@Transactional
	@Override
	public boolean removeCourse(Long courseId) throws CourseNotFoundException {
		CourseEntity newCourse = courseRepo.findById(courseId).orElse(null);
		if (newCourse == null) {
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
				throw new CourseNotFoundException("No Such Course");
			}

			course = parser.parse(courseRepo.save(parser.parse(course)));
		}

		return course;
	}

	/**
	 * service implementation for viewing a course in repository
	 **/
	@Transactional
	@Override
	public CourseModel viewCourse(Long courseid) throws CourseNotFoundException {
		CourseEntity oldCourse = courseRepo.findById(courseid).orElse(null);
		if (oldCourse == null) {
			throw new CourseNotFoundException("Course with id doesn't exists");
		} else {
			return parser.parse(courseRepo.findById(courseid).get());
		}
	}

	/**
	 * service implementation for viewing all courses in repository
	 **/
	@Transactional
	@Override
	public List<CourseModel> viewAllCourses() {
		return courseRepo.findAll().stream().map(course -> parser.parse(course)).collect(Collectors.toList());
	}

}