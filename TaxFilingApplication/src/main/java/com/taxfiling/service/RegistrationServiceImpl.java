package com.taxfiling.service;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.exception.DuplicateEntryFoundException;
import com.taxfiling.exception.EntityNotFoundException;
import com.taxfiling.repository.AdminRepository;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.EmployerRepository;
import com.taxfiling.repository.RepresentativeRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	EmployerRepository employerRepo;

	@Autowired
	RepresentativeRepository representativeRepo;

	@Autowired
	AdminRepository adminRepo;

	public int registerCustomer(Customer c) {
		try {
			customerRepo.save(c);
			return 1;
		} catch (DataIntegrityViolationException ex) {
			if (ex.getCause().getClass().equals(ConstraintViolationException.class)) {
				throw new DuplicateEntryFoundException("Duplicate entry", c.getEmail() + " already exists!",
						"Try with different email", "Do you already have an account? Try logging in",
						"Reach out to ithelpdesk@taxportal.com");
			}
			ex.printStackTrace();
		}
		return 0;
	}

	public int registerEmployer(Employer e) {
		try {
			employerRepo.save(e);
			return 1;
		} catch (DataIntegrityViolationException ex) {
			if (ex.getCause().getClass().equals(ConstraintViolationException.class)) {
				throw new DuplicateEntryFoundException("Duplicate entry", e.getEmail() + " already exists!",
						"Try with different email", "Do you already have an account? Try logging in",
						"Reach out to ithelpdesk@taxportal.com");
			}
			ex.printStackTrace();
		}
		return 0;
	}

	public int registerRepresentative(Representative r) {
		try {
			representativeRepo.save(r);
			return 1;
		} catch (DataIntegrityViolationException ex) {
			if (ex.getCause().getClass().equals(ConstraintViolationException.class)) {
				throw new DuplicateEntryFoundException("Duplicate entry", r.getEmail() + " already exists!",
						"Try with different email", "Do you already have an account? Try logging in",
						"Reach out to ithelpdesk@taxportal.com");
			}
		}
		return 0;
	}

	@Override
	public Employer findEmployerByOrg(String newOrgName) {
		Employer e = employerRepo.findEmployer(newOrgName);
		if (e == null) {
			throw new EntityNotFoundException("Wrong organization name",
					"Organization with name: " + newOrgName + " doesn't exists", "Recheck organization name",
					"Check list of Organizations", "Reach out to ithelpdesk@taxportal.com");
		}
		return e;
	}

	@Override
	public Admin findAdmin(String id) {
		return adminRepo.findById(id).orElse(null);
	}
}
