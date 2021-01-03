package com.taxfiling.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.exception.EntityNotFoundException;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.EmployerRepository;
import com.taxfiling.repository.RepresentativeRepository;

@Service
public class ViewProfileServiceImpl implements ViewProfileService {

	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private EmployerRepository employerRepo;

	@Autowired
	private RepresentativeRepository representativeRepo;

	@Override
	public Customer viewCustomerProfile(Long customerId) {
		Customer c = customerRepo.findById(customerId).orElse(null);
		if (c == null)
			throw new EntityNotFoundException("Wrong id", "Customer with id: " + customerId + " doesn't exists",
					"Recheck id", "Check list of Customers", "Reach out to ithelpdesk@taxportal.com");
		return c;
	}

	@Override
	public Employer viewEmployerProfile(Long employerId) {
		Employer e = employerRepo.findById(employerId).orElse(null);
		if (e == null)
			throw new EntityNotFoundException("Wrong id", "Employer with id: " + employerId + " doesn't exists",
					"Recheck id", "Check list of Employers", "Reach out to ithelpdesk@taxportal.com");
		return e;
	}

	@Override
	public Representative viewRepresentativeProfile(Long representativeId) {
		Representative r = representativeRepo.findById(representativeId).orElse(null);
		if (r == null)
			throw new EntityNotFoundException("Wrong id", "Customer with id: " + representativeId + " doesn't exists",
					"Recheck id", "Check list of Representaives", "Reach out to ithelpdesk@taxportal.com");
		return r;
	}
}
