package com.cg.ucaa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ucaa.entities.CourseEntity;
import com.cg.ucaa.entities.UniversityStaffMemberEntity;
import com.cg.ucaa.exception.CourseNotFoundException;
import com.cg.ucaa.models.CourseModel;
import com.cg.ucaa.repository.ICourseRepository;
import com.cg.ucaa.service.CourseServiceImpl;

/**
 * Test class
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class CourseServiceImplTests {

	/* mocking the repository */
	@Mock
	private ICourseRepository repo;

	/*
	 * injecting course repository marked as @Mock into course service
	 * implementation
	 */
	@InjectMocks
	private CourseServiceImpl csImpl;

	/**
	 * Test Case 1- listing all the courses in the university
	 */
	@Test
	@DisplayName("CourseServiceImpl::viewAllCourses should return list of existing courses as CourseModel List")
	void testViewAllCourses() {

		UniversityStaffMemberEntity entity = new UniversityStaffMemberEntity(1L, "dean@1234", "Full Stack Trainer");

		List<CourseEntity> testData = Arrays.asList(new CourseEntity[] {
				new CourseEntity(1L, "Java CORE", "3 Months", LocalDate.parse("2021-05-01"),
						LocalDate.parse("2021-08-10"), "3500", entity),
				new CourseEntity(2L, "Spring", "2 Months", LocalDate.parse("2021-05-01"), LocalDate.parse("2021-07-10"),
						"1500", entity) });

		/* when repo.findAll() is called, then test data */
		Mockito.when(repo.findAll()).thenReturn(testData);

		List<CourseModel> expected = Arrays.asList(new CourseModel[] {
				new CourseModel(1L, "Java CORE", "3 Months", LocalDate.parse("2021-05-01"),
						LocalDate.parse("2021-08-10"), "3500", 1L),
				new CourseModel(2L, "Spring", "2 Months", LocalDate.parse("2021-05-01"), LocalDate.parse("2021-07-10"),
						"1500", 1L) });

		List<CourseModel> actual = csImpl.viewAllCourses();

		assertEquals(expected, actual);
	}

	/**
	 * Test Case 2 - listing the specific course in the university
	 */
	@Test
	@DisplayName("CourseServiceImpl::viewCourse should return existing course as CourseModel is provided with existing courseId")
	void testViewCourse() throws CourseNotFoundException {

		UniversityStaffMemberEntity entity = new UniversityStaffMemberEntity(1L, "dean@1234", "Full Stack Trainer");
		
		CourseEntity testData = new CourseEntity(1L, "Java CORE", "3 Months", LocalDate.parse("2021-05-01"),
				LocalDate.parse("2021-08-10"), "3500", entity);
		CourseModel expected = new CourseModel(1L, "Java CORE", "3 Months", LocalDate.parse("2021-05-01"),
				LocalDate.parse("2021-08-10"), "3500", 1L);

		Mockito.when(repo.findById(testData.getCourseId())).thenReturn(Optional.of(testData));

		CourseModel actual = csImpl.viewCourse((expected.getCourseId()));
		assertEquals(expected, actual);
	}

	/**
	 * Test Case 3 - providing null if the course isn't present in the university
	 */
	@Test
	@DisplayName("CourseServiceImpl::viewCourse should return null given nonexisting courseId")
	void testViewCourse2() throws CourseNotFoundException {
		CourseModel actual = null;
		try {
			Mockito.when(repo.findById(101L)).thenReturn(Optional.empty());
			actual = csImpl.viewCourse(101L);
			if (actual.equals(null)) {
				assertEquals(null, actual);
			}
		} catch (CourseNotFoundException excep) {
			assertEquals(null, actual);
		}
	}


	/**
	 * Test Case 4 - removing the course in the university
	 */
	@Test
	@DisplayName("CourseServiceImpl::removeCourse should remove course for given courseId")
	void testRemoveCourse() throws CourseNotFoundException {
		UniversityStaffMemberEntity entity = new UniversityStaffMemberEntity(1L, "dean@1234", "Full Stack Trainer");
		CourseEntity course = new CourseEntity(1L, "Hibernate", "3 Months", LocalDate.parse("2021-05-01"),
				LocalDate.parse("2021-08-10"), "3500", entity);
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(course));
		Mockito.doNothing().when(repo).deleteById(1L);
		boolean result = csImpl.removeCourse(1L);
		assertTrue(result);

	}

	/**
	 * Test Case 5 - facilitating null if no courses are present
	 */
	@Test
	@DisplayName("CourseServiceImpl::viewAllCourse should return null as no course is present")
	void testViewAllStaffs2() {

		List<CourseEntity> testData = Arrays.asList(new CourseEntity[] {});

		/* when repo.findAll() is called, then test data */
		Mockito.when(repo.findAll()).thenReturn(testData);
		List<CourseModel> expected = Arrays.asList(new CourseModel[] {});

		List<CourseModel> actual = csImpl.viewAllCourses();

		assertEquals(expected, actual);
	}

}