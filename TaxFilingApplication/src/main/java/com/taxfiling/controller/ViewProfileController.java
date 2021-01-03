package com.taxfiling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.ViewProfileService;

@RestController
public class ViewProfileController {

	@Autowired
	private ViewProfileService viewProfileService;

	@GetMapping("/viewCustomerProfile/{customerId}")
	public Customer viewCustomerProfile(@PathVariable("customerId") Long customerId) {
		return viewProfileService.viewCustomerProfile(customerId);
	}

	@GetMapping("/viewEmployerProfile/{employerId}")
	public Employer viewEmployerProfile(@PathVariable("employerId") Long employerId) {
		return viewProfileService.viewEmployerProfile(employerId);
	}

	@GetMapping("/viewRepresentativeProfile/{representativeId}")
	public Representative viewRepresentativeProfile(@PathVariable("representativeId") Long representativeId) {
		return viewProfileService.viewRepresentativeProfile(representativeId);
	}
	
}
