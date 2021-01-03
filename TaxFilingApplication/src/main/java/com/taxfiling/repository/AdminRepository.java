package com.taxfiling.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.taxfiling.entity.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

	@Query("SELECT a FROM Admin a where a.email=:id and a.password=:password")
	public Admin loginAdmin(String id, String password);
}