package com.cg.ucaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ucaa.entities.AdmissionEntity;

@Repository
public interface IAdmissionRepository extends JpaRepository<AdmissionEntity, Long> {

}