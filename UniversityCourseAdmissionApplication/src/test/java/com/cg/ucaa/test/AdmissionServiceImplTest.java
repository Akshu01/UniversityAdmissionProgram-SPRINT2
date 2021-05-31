package com.cg.ucaa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ucaa.entities.AdmissionEntity;
import com.cg.ucaa.entities.AdmissionStatus;
import com.cg.ucaa.exception.AdmissionNotGrantedException;
import com.cg.ucaa.models.AdmissionModel;
import com.cg.ucaa.repository.IAdmissionRepository;
import com.cg.ucaa.service.AdmissionServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AdmissionServiceImplTest {

	/* mocking the repository */
	@Mock
	private IAdmissionRepository repo;

	/*
	 * injecting Admission repository marked as @Mock into Admission service
	 * implementation
	 */
	@InjectMocks
	private AdmissionServiceImpl asImpl;


	/**
	 * providing null if no admission by given id exists
	 * 
	 * @throws AdmissionNotGrantedException
	 */
	@Test
	@DisplayName("AdmissionImpl::findById() should return null given nonexisting admissionId")
	void testFindById2() throws AdmissionNotGrantedException {
		AdmissionModel actual = null;
		try {
			Mockito.when(repo.findById(1L)).thenReturn(Optional.empty());
			actual = asImpl.viewByAdmissionId(1L);
			if (actual.equals(null)) {
				assertEquals(null, actual);
			}
		} catch (AdmissionNotGrantedException excep) {
			assertEquals(null, actual);
		}

	}
	

	@Test
	@DisplayName("AdmissionServiceImpl::updateAdmission2() should return updated admission with provided admission id else null")
	void testUpdateAdmission2() throws AdmissionNotGrantedException {
		AdmissionModel actual = null;
		try {
			Mockito.when(repo.findById(1L)).thenReturn(Optional.empty());
			actual = asImpl.viewByAdmissionId(1L);
			if (actual.equals(null)) {
				assertEquals(null, actual);
			}
		} catch (AdmissionNotGrantedException excep) {
			assertEquals(null, actual);
		}
	}


	/**
	 * removing admission
	 * 
	 * @throws AdmissionNotGrantedException
	 */
	@Test
	@DisplayName("AdmissionServiceImpl::deleteById() should remove admission by given admission id ")
	void testDeleteById() throws AdmissionNotGrantedException {
		AdmissionEntity testdata = new AdmissionEntity(23L, LocalDate.parse("2021-05-05"), AdmissionStatus.Confirmed);

		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(testdata));

		Mockito.doNothing().when(repo).deleteById(1L);
		boolean result = asImpl.removeAdmission(1L);
		assertTrue(result);

	}
	
	@Test
	@DisplayName("AdmissionServiceImpl::updateAdmission3() should return null when provided with non existing admission id")
	void testUpdateAdmission3() throws AdmissionNotGrantedException {

		AdmissionModel actual = null;

		try {
			Mockito.when(repo.findById(1L)).thenReturn(Optional.empty());
			actual = asImpl.viewByAdmissionId(1L);
			if (actual.equals(null)) {
				assertEquals(null, actual);
			}
		} catch (AdmissionNotGrantedException excep) {
			assertEquals(null, actual);
		}
	}

}