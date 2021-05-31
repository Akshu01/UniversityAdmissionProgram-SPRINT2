package com.cg.ucaa.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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

import com.cg.ucaa.entities.AdmissionCommiteeMemberEntity;
import com.cg.ucaa.exception.AdmissionCommiteeMemberNotFoundException;
import com.cg.ucaa.models.AdmissionCommiteeMemberModel;
import com.cg.ucaa.repository.IAdmissionCommiteeMemberRepository;
import com.cg.ucaa.service.AdmissionCommiteeMemberServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AdmissionCommiteeMemberTests {

	/* mocking the repository */
	@Mock
	private IAdmissionCommiteeMemberRepository repo;

	/*
	 * injecting AdmissionCommitee repository marked as @Mock into
	 * AdmissionCommitee service implementation
	 */
	@InjectMocks
	private AdmissionCommiteeMemberServiceImpl acmImpl;

	/**
	 * Test Case 1 - listing/Retrieving all the committee members of the university
	 * 
	 * @throws AdmissionCommiteeMemberNotFoundException
	 */
	@Test
	@DisplayName("AdmissionCommiteeMemberServiceImpl::viewAllCommiteeMembers should return list of existing members as AdmissionCommiteeMemberModel List")
	void testViewAllCommiteeMembers() throws AdmissionCommiteeMemberNotFoundException {

		List<AdmissionCommiteeMemberEntity> testData = Arrays.asList(
				new AdmissionCommiteeMemberEntity[] { new AdmissionCommiteeMemberEntity(1L, "Akshat", "9582880633"),
						new AdmissionCommiteeMemberEntity(2L, "Dj", "9582880603") });

		/* when repo.findAll() is called, then test data */
		Mockito.when(repo.findAll()).thenReturn(testData);
		List<AdmissionCommiteeMemberModel> expected = Arrays.asList(
				new AdmissionCommiteeMemberModel[] { new AdmissionCommiteeMemberModel(1L, "Akshat", "9582880633"),
						new AdmissionCommiteeMemberModel(2L, "Dj", "9582880603") });

		List<AdmissionCommiteeMemberModel> actual = acmImpl.viewAllCommiteeMembers();

		assertEquals(expected, actual);
	}

	/**
	 * Test Case 2 - listing a specific member related to the committee
	 * 
	 * @throws AdmissionCommiteeMemberNotFoundException
	 */
	@Test
	@DisplayName("AdmissionCommiteeMemberServiceImpl::viewMember should return existing member as  AdmissionCommiteeMemberfModel is provided with existing Id")
	void testViewStaff() throws AdmissionCommiteeMemberNotFoundException {

		AdmissionCommiteeMemberEntity testdata = new AdmissionCommiteeMemberEntity(1L, "Akshat", "9582880633");
		AdmissionCommiteeMemberModel expected = new AdmissionCommiteeMemberModel(1L, "Akshat", "9582880633");

		Long id = testdata.getAdminId();
		Mockito.when(repo.findById(id)).thenReturn(Optional.of(testdata));

		AdmissionCommiteeMemberModel actual = acmImpl.viewCommiteeMember((expected.getAdminId()));
		assertEquals(expected, actual);
	}

	/**
	 * Test Case 3 - adding members in the committee
	 * 
	 * @throws AdmissionCommiteeMemberNotFoundException
	 */
	@Test
	@DisplayName("AdmissionCommiteeMemberServiceImpl::addCommiteeMember should return member saved with given Id")
	void testAddMember()
			throws AdmissionCommiteeMemberNotFoundException {

		AdmissionCommiteeMemberEntity testdata = new AdmissionCommiteeMemberEntity(1L,"Akshat", "9582880633");
		AdmissionCommiteeMemberModel expected  = new AdmissionCommiteeMemberModel(1L, "Akshat", "9582880633");

		Mockito.when(repo.save(testdata)).thenReturn(testdata);
		AdmissionCommiteeMemberModel actual = acmImpl.addCommiteeMember(expected);

		assertEquals(expected, actual);
	}

	/**
	 * Test Case 4 - updating members in the committee
	 * @throws AdmissionCommiteeMemberNotFoundException
	 */
	@Test
	@DisplayName("AdmissionCommiteeMemberServiceImpl::updateCommiteeStaff should return updated member with provided Id")
	void testUpdateMember()
			throws AdmissionCommiteeMemberNotFoundException {

		AdmissionCommiteeMemberEntity testdata = new AdmissionCommiteeMemberEntity(1L, "Akshat", "9582880633");
		AdmissionCommiteeMemberModel expected = new AdmissionCommiteeMemberModel(1L, "Shikhar", "9582880633");
		
		testdata.setAdminName("Shikhar");
		Mockito.when(repo.save(testdata)).thenReturn(testdata);
		AdmissionCommiteeMemberModel actual = acmImpl.addCommiteeMember(expected);

		assertEquals(expected, actual);
	}

	/**
	 * Test Case 5 - removing members in the committee
	 * 
	 * @throws AdmissionCommiteeMemberNotFoundException
	 */
	@Test
	@DisplayName("AdmissionCommiteeMemberServiceImpl::removeMember should remove member for given Id")
	void testRemoveMember()
			throws AdmissionCommiteeMemberNotFoundException {
		AdmissionCommiteeMemberEntity testdata = new AdmissionCommiteeMemberEntity(1L, "Akshat", "9582880633");
		Mockito.when(repo.findById(1L)).thenReturn(Optional.of(testdata));
		Mockito.doNothing().when(repo).deleteById(1L);
		boolean expected = acmImpl.removeCommiteeMember(1L);
		assertTrue(expected);
	}

	/**
	 * Test Case 6 - providing null if member with specific id exists in the committee
	 * @throws AdmissionCommiteeMemberNotFoundException
	 */
	@Test
	@DisplayName("AdmissionCommiteeMemberServiceImpl::viewMember2 should return null given nonexisting Id")
	void testViewMember2() throws AdmissionCommiteeMemberNotFoundException {

		Mockito.when(repo.findById(101L)).thenReturn(Optional.empty());

		AdmissionCommiteeMemberModel actual = acmImpl.viewCommiteeMember(101L);
		assertNull(actual);
	}

	/**
	 * Test Case 7 - facilitating null if no members are present in the committee
	 * @throws AdmissionCommiteeMemberNotFoundException
	 */
	@Test
	@DisplayName("AdmissionCommiteeMemberServiceImpl::viewAllCommiteemembers should return null")
	void testViewAdmissionCommtee2() throws AdmissionCommiteeMemberNotFoundException {

		List<AdmissionCommiteeMemberEntity> testData = Arrays.asList(new AdmissionCommiteeMemberEntity[] {});

		/* when repo.findAll() is called, then test data */
		Mockito.when(repo.findAll()).thenReturn(testData);
		List<AdmissionCommiteeMemberModel> expected = Arrays.asList(new AdmissionCommiteeMemberModel[] {});

		List<AdmissionCommiteeMemberModel> actual = acmImpl.viewAllCommiteeMembers();

		assertEquals(expected, actual);
	}
}
