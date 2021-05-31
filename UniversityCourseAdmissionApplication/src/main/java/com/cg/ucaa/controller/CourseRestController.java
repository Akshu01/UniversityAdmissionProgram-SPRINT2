package com.cg.ucaa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ucaa.exception.CourseNotFoundException;

import com.cg.ucaa.models.CourseModel;

import com.cg.ucaa.service.ICourseService;

/**
 * Controller class to facilitate operations
 */
@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseRestController {
	@Autowired
	private ICourseService courseService;

	/**
	 * Fetching course by course id
	 * 
	 * @param courseId
	 * @return
	 */

	@GetMapping("/{courseId}")
	public ResponseEntity<CourseModel> viewCourse(@PathVariable("courseId") Long id) throws CourseNotFoundException {
		return ResponseEntity.ok(courseService.viewCourse(id));
	}

	/**
	 * Fetching all courses
	 * 
	 * @return
	 */

	@GetMapping
	public ResponseEntity<List<CourseModel>> viewAllCourse() {
		return new ResponseEntity<>(courseService.viewAllCourses(), HttpStatus.OK);

	}

	/**
	 * Deleting course by course id
	 * 
	 * @param courseId
	 * @return
	 */

	@DeleteMapping("/{courseId}")
	public ResponseEntity<Boolean> removeCourse(@PathVariable("courseId") Long courseId)
			throws CourseNotFoundException {
		Boolean result = courseService.removeCourse(courseId);
		return new ResponseEntity<>(result, HttpStatus.OK);

	}

	/**
	 * Adding course
	 * 
	 * @return
	 */
	@PostMapping
	public ResponseEntity<CourseModel> addCourse(@RequestBody CourseModel course) throws CourseNotFoundException {
		return new ResponseEntity<>(courseService.addCourse(course), HttpStatus.OK);

	}

	/**
	 * Updating course details
	 * 
	 * @return
	 */
	@PutMapping
	public ResponseEntity<CourseModel> updateCourse(@RequestBody CourseModel course) throws CourseNotFoundException {
		return new ResponseEntity<>(courseService.updateCourse(course), HttpStatus.OK);

	}

}