package com.cg.ucaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ucaa.entities.AdmissionCommiteeMemberEntity;

@Repository
public interface IAdmissionCommiteeMemberRepository extends JpaRepository<AdmissionCommiteeMemberEntity, Long> {
	
	@Query("SELECT e from admissioncommiteemember e where e.adminName=?1 and e.adminContact=?2")
	public AdmissionCommiteeMemberEntity findByNameAndNumber(String name, String number);
}
