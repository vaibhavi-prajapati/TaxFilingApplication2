package com.taxfiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfiling.entity.Employer;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {

	@Query("SELECT e FROM Employer e where e.employerId=:id and e.password=:password")
	Employer loginEmployer(long id, String password);

	@Query("SELECT e FROM Employer e where e.organization=:newOrgName")
	Employer findEmployer(String newOrgName);
}