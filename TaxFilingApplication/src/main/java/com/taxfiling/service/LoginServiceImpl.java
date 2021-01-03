package com.taxfiling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.repository.AdminRepository;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.EmployerRepository;
import com.taxfiling.repository.RepresentativeRepository;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	EmployerRepository employerRepo;

	@Autowired
	RepresentativeRepository representativeRepo;

	@Autowired
	AdminRepository adminRepo;

	@Override
	public Customer loginCustomer(Long customerId, String password) {
		return customerRepo.loginCustomer(customerId, password);
	}

	@Override
	public Employer loginEmployer(long id, String password) {
		return employerRepo.loginEmployer(id, password);
	}

	@Override
	public Representative loginRepresentative(long id, String password) {
		return representativeRepo.loginRepresentative(id, password);
	}

	@Override
	public Admin loginAdmin(String id, String password) {
		return adminRepo.loginAdmin(id, password);
	}
}
