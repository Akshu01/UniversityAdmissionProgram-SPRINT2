package com.cg.ucaa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
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

import com.cg.ucaa.entities.ApplicantEntity;
import com.cg.ucaa.exception.ApplicantNotFoundException;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.repository.IApplicantRepository;
import com.cg.ucaa.service.ApplicantServiceImpl;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ApplicantServiceImplTest {

	/* mocking the repository */
	@Mock
	private IApplicantRepository repo;

	/*
	 * injecting Admission repository marked as @Mock into
	 * Admission service implementation
	 */
	@InjectMocks
	private ApplicantServiceImpl asImpl;
	
	/*
	 * listing all applicants*/
	@Test
	@DisplayName("ApplicantServiceImpl::viewAllApplicants() should return all existing applicants")
	void testViewAllApplicants() throws ApplicantNotFoundException {
		List<ApplicantEntity> testdata = Arrays.asList(new ApplicantEntity[] {
				new ApplicantEntity(5L,"Abhay","9878065437","B.tech",new BigDecimal(60)),
				new ApplicantEntity(6L,"Tanu","9870069976","B.tech",new BigDecimal(68))});
		
		Mockito.when(repo.findAll()).thenReturn(testdata);
		List<ApplicantModel> expected = Arrays.asList(new ApplicantModel[] {
				new ApplicantModel(5L,"Abhay","9878065437","B.tech",new BigDecimal(60)),
				new ApplicantModel(6L,"Tanu","9870069976","B.tech",new BigDecimal(68)) });

		List<ApplicantModel> actual = asImpl.viewAllApplicants();

		assertEquals(expected, actual);
	}
	
	/**
	 * finding an applicant by giving applicant id
	 */
	@Test
	@DisplayName("ApplicantServiceImpl::viewApplicant should return applicant ApplicantModel when provided with existing applicant id")
	void testViewApplicant() throws ApplicantNotFoundException {

		ApplicantEntity testdata = new ApplicantEntity(5L,"Abhay","9878065437","B.tech",new BigDecimal(60));
		ApplicantModel expected = new ApplicantModel(5L,"Abhay","9878065437","B.tech",new BigDecimal(60));

		Mockito.when(repo.findById(testdata.getApplicantId())).thenReturn(Optional.of(testdata));

		ApplicantModel actual = asImpl.viewApplicant((expected.getApplicantId()));
		assertEquals(expected, actual);
	}
	
	/**
	 * providing null if no applicant exists 
	 */
	@Test
	@DisplayName("ApplicantServiceImpl::viewApplicant should return null given nonexisting applicantId")
	void testViewApplicant2() throws ApplicantNotFoundException {

		Mockito.when(repo.findById(101L)).thenReturn(Optional.empty());

		ApplicantModel actual = asImpl.viewApplicant(101L);
		assertNull(actual);
	}

	/**
	 * adding applicants
	 */
	@Test
	@DisplayName("AdmissionServiceImpl::addApplicant should return applicant saved with given applicantId")
	void testAddApplicant() throws ApplicantNotFoundException {

		ApplicantEntity testdata = new ApplicantEntity(6L,"Tanu","9870069976","B.tech",new BigDecimal(68));
		ApplicantModel expected = new ApplicantModel(6L,"Tanu","9870069976","B.tech",new BigDecimal(68));

		Mockito.when(repo.save(testdata)).thenReturn(testdata);
		ApplicantModel actual = asImpl.registerApplicant(expected);

		assertEquals(expected, actual);
	}
	
	/**
	 * updating applicant details
	 */
	@Test
	@DisplayName("ApplicantServiceImpl::updateApplicant should return updated applicant with provided applicantId")
	void testUpdateUniversityStaff() throws ApplicantNotFoundException {

		ApplicantEntity testdata = new ApplicantEntity(1L,"Rachana","9870065437","B.tech",new BigDecimal(80));
		ApplicantModel expected = new ApplicantModel(1L,"Rachana","9870065407","B.tech",new BigDecimal(80));
		
		testdata.setMobileNumber("9870065407");
		Mockito.when(repo.save(testdata)).thenReturn(testdata);
		
		
		ApplicantModel actual = asImpl.registerApplicant(expected);

		assertEquals(expected, actual);
	}
	
	/**
	 * removing applicants
	 */
	@Test
	@DisplayName("ApplicantServiceImpl::removeApplicant should remove applicant for given applicantId")
	void testRemoveStaff() throws ApplicantNotFoundException {
		ApplicantEntity testdata = new ApplicantEntity(4L,"Rachana","9870065437","B.tech",new BigDecimal(80));
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(repo).deleteById(1L);
		boolean result = asImpl.removeApplicant(1L);
		assertTrue(result);
	}


}
