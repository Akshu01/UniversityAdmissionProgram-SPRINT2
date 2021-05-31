package com.cg.ucaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ucaa.entities.UniversityStaffMemberEntity;

/**
 * This is a repository extending JPA Repository
 * @author Akshat Kumar
 *
 */
@Repository
public interface IUniversityStaffMemberRepository extends JpaRepository<UniversityStaffMemberEntity, Long> {

}
