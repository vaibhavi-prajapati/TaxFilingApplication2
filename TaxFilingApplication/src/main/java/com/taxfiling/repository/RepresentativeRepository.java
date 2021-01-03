package com.taxfiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfiling.entity.Representative;

@Repository
public interface RepresentativeRepository extends JpaRepository<Representative, Long> {

	@Query("SELECT r FROM Representative r where r.representativeId=:id and r.password=:password")
	public Representative loginRepresentative(long id, String password);
}
