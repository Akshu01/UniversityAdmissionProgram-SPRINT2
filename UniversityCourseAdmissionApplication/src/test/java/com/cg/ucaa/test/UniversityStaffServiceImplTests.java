package com.cg.ucaa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

import com.cg.ucaa.entities.UniversityStaffMemberEntity;
import com.cg.ucaa.exception.UniversityStaffMemberNotFoundException;
import com.cg.ucaa.models.UniversityStaffMemberModel;
import com.cg.ucaa.repository.IUniversityStaffMemberRepository;
import com.cg.ucaa.service.UniversityStaffMemberImpl;

/**
 * Test class
 * @author Akshat Kumar
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UniversityStaffServiceImplTests {

	/* mocking the repository */
	@Mock
	private IUniversityStaffMemberRepository repo;

	/*
	 * injecting UniversityStaffMember repository marked as @Mock into
	 * UniversityStaff service implementation
	 */
	@InjectMocks
	private UniversityStaffMemberImpl usmImpl;
	
	/**
	 * Test Case 1 - listing/Retrieving all the staff members of the university
	 */
	@Test
	@DisplayName("UniversityStaffMemberImpl::viewAllStaffMembers should return list of existing staffs as UniversityStaffModel List")
	void testViewAllStaffs() {

		List<UniversityStaffMemberEntity> testData = Arrays.asList(new UniversityStaffMemberEntity[] {
				new UniversityStaffMemberEntity(1L, "CAPGUS001", "HOD"),
				new UniversityStaffMemberEntity(2L, "CAPGUS002", "Professor") });

		/* when repo.findAll() is called, then test data */
		Mockito.when(repo.findAll()).thenReturn(testData);
		List<UniversityStaffMemberModel> expected = Arrays.asList(new UniversityStaffMemberModel[] {
				new UniversityStaffMemberModel(1L, "CAPGUS001", "HOD"), 
				new UniversityStaffMemberModel(2L, "CAPGUS002", "Professor")});

		List<UniversityStaffMemberModel> actual = usmImpl.viewAllStaffs();
		assertEquals(expected, actual);
	}
	
	/**
	 * Test Case 2 - listing a specific staff related to the university
	 */
	@Test
	@DisplayName("UniversityStaffMemberImpl::viewStaff should return existing staff as UniversityStaffModel is provided with existing staffId")
	void testViewStaff() throws UniversityStaffMemberNotFoundException {

		UniversityStaffMemberEntity testdata = new UniversityStaffMemberEntity(1L, "CAPGUS001", "HOD");
		UniversityStaffMemberModel expected = new UniversityStaffMemberModel(1L, "CAPGUS001", "HOD");

		Mockito.when(repo.findById(testdata.getStaffId())).thenReturn(Optional.of(testdata));

		UniversityStaffMemberModel actual = usmImpl.viewStaff((expected.getStaffId()));
		assertEquals(expected, actual);
	}
	
	/**
	 * Test Case 3 - adding staff members in the university
	 */
	@Test
	@DisplayName("UniversityStaffMemberImpl::addUniversityStaff should return staff saved with given staffId")
	void testAddUniversityStaff() throws UniversityStaffMemberNotFoundException {

		UniversityStaffMemberEntity testdata = new UniversityStaffMemberEntity(1L, "CAPGUS001", "HOD");
		UniversityStaffMemberModel expected = new UniversityStaffMemberModel(1L, "CAPGUS001", "HOD");

		Mockito.when(repo.save(testdata)).thenReturn(testdata);
		UniversityStaffMemberModel actual = usmImpl.addStaff(expected);

		assertEquals(expected, actual);
	}
	
	/**
	 * Test Case 4 - removing staff members in the university
	 */
	@Test
	@DisplayName("UniversityStaffMemberImpl::removeStaff should remove staff for given staffId")
	 void testRemoveStaff() throws UniversityStaffMemberNotFoundException {
		UniversityStaffMemberEntity testData = new UniversityStaffMemberEntity(1L, "CAPGUS001", "HOD");
		
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(testData));
		Mockito.doNothing().when(repo).deleteById(1L);
		boolean result = usmImpl.removeStaff(1L);
		assertTrue(result);
	}
	
	/**
	 * Test Case 5 - providing null if staff member with specific id does not exists in the university
	 */
	@Test()
	@DisplayName("UniversityStaffMemberImpl::viewStaff should return null given nonexisting staffId")
	void testViewStaff2(){
		UniversityStaffMemberModel actual = null;
		try {
		Mockito.when(repo.findById(1L)).thenReturn(Optional.empty());
		actual = usmImpl.viewStaff(1L);
		if(actual.equals(null))
		{
			assertEquals(null,actual);
		}
		}catch (UniversityStaffMemberNotFoundException excep) {
			assertEquals(null,actual);
		}
	}
	
	/**
	 * Test Case 6 - facilitating null if no staff members are present in the university
	 */
	@Test
	@DisplayName("UniversityStaffMemberImpl::viewAllStaffMembers should return null as no existing staffs are present in UniversityStaffModel List")
	void testViewAllStaffs2() {

		List<UniversityStaffMemberEntity> testData = Arrays.asList(new UniversityStaffMemberEntity[] {});

		/* when repo.findAll() is called, then test data */
		Mockito.when(repo.findAll()).thenReturn(testData);
		List<UniversityStaffMemberModel> expected = Arrays.asList(new UniversityStaffMemberModel[] {});

		List<UniversityStaffMemberModel> actual = usmImpl.viewAllStaffs();

		assertEquals(expected, actual);
	}
	
	/**
	 * Test Case 7 - updating staff members in the university
	 */
	@Test
	@DisplayName("UniversityStaffMemberImpl::updateUniversityStaff should return updated staff with provided staffId")
	void testUpdateUniversityStaff() throws UniversityStaffMemberNotFoundException {

		UniversityStaffMemberEntity testData = new UniversityStaffMemberEntity(1L, "CAPGUS002", "HOD");
		UniversityStaffMemberModel expectedData = new UniversityStaffMemberModel(1L, "CAPGUS001", "HOD");
		
		testData.setPassword("CAPGUS001");
		
		Mockito.when(repo.save(testData)).thenReturn(testData);
		UniversityStaffMemberModel actual = usmImpl.addStaff(expectedData);

		assertEquals(expectedData, actual);
	}
	

}
