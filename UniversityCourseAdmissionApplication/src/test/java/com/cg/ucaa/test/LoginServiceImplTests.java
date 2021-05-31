package com.cg.ucaa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ucaa.entities.AdmissionCommiteeMemberEntity;
import com.cg.ucaa.entities.ApplicantEntity;
import com.cg.ucaa.entities.LoginEntity;
import com.cg.ucaa.exception.AdmissionCommiteeMemberNotFoundException;
import com.cg.ucaa.exception.ApplicantNotFoundException;
import com.cg.ucaa.exception.LoginFailedException;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.models.ApplicantModel;
import com.cg.ucaa.models.LoginModel;
import com.cg.ucaa.repository.IAdmissionCommiteeMemberRepository;
import com.cg.ucaa.repository.IApplicantRepository;
import com.cg.ucaa.repository.ILoginRepository;
import com.cg.ucaa.service.AdmissionCommiteeMemberServiceImpl;
import com.cg.ucaa.service.ApplicantServiceImpl;
import com.cg.ucaa.service.LoginServiceImpl;

/**
 * Test Class
 * 
 * @author Akshat Kumar
 *
 */
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class LoginServiceImplTests {

	/* mocking the repository */
	@Mock
	private ILoginRepository repo;

	/*
	 * injecting Login repository marked as @Mock into Login service implementation
	 */
	@InjectMocks
	private LoginServiceImpl usmImpl;

	/* mocking the repository */
	@Mock
	private IAdmissionCommiteeMemberRepository repoAdmin;

	@Mock
	private IApplicantRepository repoApplicant;

	/*
	 * injecting AdmissionCommitee repository marked as @Mock into AdmissionCommitee
	 * service implementation
	 */
	@InjectMocks
	private AdmissionCommiteeMemberServiceImpl acmImpl;
	@InjectMocks
	private ApplicantServiceImpl appImpl;

	@Test
	void signupAdmin() throws AdmissionCommiteeMemberNotFoundException {
		AdmissionCommiteeMemberEntity testdata = new AdmissionCommiteeMemberEntity(1L, "Akshat", "9582880633");
		AdmissionCommiteeMemberModel expected = new AdmissionCommiteeMemberModel(1L, "Akshat", "9582880633");

		Mockito.when(repoAdmin.save(testdata)).thenReturn(testdata);
		AdmissionCommiteeMemberModel actual = acmImpl.addCommiteeMember(expected);

		assertEquals(expected, actual);
	}

	@Test
	void signupAdmin1() throws AdmissionCommiteeMemberNotFoundException {
		AdmissionCommiteeMemberModel expected = null;

		AdmissionCommiteeMemberModel actual = acmImpl.addCommiteeMember(expected);

		assertNull(actual);

	}

	@Test
	void signupApplicant1() throws ApplicantNotFoundException {
		ApplicantModel expected = null;

		ApplicantModel actual = appImpl.registerApplicant(expected);

		assertNull(actual);

	}

	@Test
	void signupApplicant2() throws ApplicantNotFoundException {
		ApplicantEntity testdata = new ApplicantEntity(555700L, "Abhay", "9878065437", "B.tech", new BigDecimal(60));
		ApplicantModel expected = new ApplicantModel(555700L, "Abhay", "9878065437", "B.tech", new BigDecimal(60));

		Mockito.when(repoApplicant.save(testdata)).thenReturn(testdata);
		ApplicantModel actual = appImpl.registerApplicant(expected);

		assertEquals(expected, actual);
	}

	@Test
	void signupApplicant3() throws LoginFailedException {
		LoginEntity testdata = new LoginEntity(1001L, "Akshat", "Kumar", "akshat@gmail.com", "puresoult@1",
				"9582880633", "House No. 12,Block- k,Gr. Noida", "201308");
		LoginModel expected = new LoginModel(1001L, "Akshat", "Kumar", "akshat@gmail.com", "puresoult@1", "9582880633",
				"House No. 12,Block- k,Gr. Noida", "201308");

		Mockito.when(repo.save(testdata)).thenReturn(testdata);
		LoginModel actual = usmImpl.signUp(expected);

		assertEquals(expected, actual);
	}
}