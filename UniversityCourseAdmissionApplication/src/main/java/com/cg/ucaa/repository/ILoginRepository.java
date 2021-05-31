package com.cg.ucaa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ucaa.entities.LoginEntity;

/**
 * This is a repository extending JPA Repository
 * @author Akshat Kumar
 *
 */
@Repository
public interface ILoginRepository extends JpaRepository<LoginEntity, Long>{
	 
	@Query("SELECT e from logins e where e.email=?1 and e.password=?2")
	public LoginEntity findByEmailAndPassword(String email,String password);
	
}
