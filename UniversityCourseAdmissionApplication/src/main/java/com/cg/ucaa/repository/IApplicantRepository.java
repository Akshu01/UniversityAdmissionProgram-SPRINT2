package com.cg.ucaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ucaa.entities.ApplicantEntity;

@Repository
public interface IApplicantRepository extends JpaRepository<ApplicantEntity, Long> {

}