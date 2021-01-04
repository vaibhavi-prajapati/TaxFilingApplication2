package com.taxfiling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.ViewProfileService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ViewProfileController {

	Logger logger = LoggerFactory.getLogger(ViewProfileController.class);

	@Autowired
	private ViewProfileService viewProfileService;

	@GetMapping("/viewCustomerProfile/{customerId}")
	@ApiOperation("Enter the customer Id")
	public Customer viewCustomerProfile(@PathVariable("customerId") Long customerId) {
		return viewProfileService.viewCustomerProfile(customerId);
	}

	@GetMapping("/viewEmployerProfile/{employerId}")
	@ApiOperation("Enter the employer Id")
	public Employer viewEmployerProfile(@PathVariable("employerId") Long employerId) {
		return viewProfileService.viewEmployerProfile(employerId);
	}

	@GetMapping("/viewRepresentativeProfile/{representativeId}")
	@ApiOperation("Enter the representative Id")
	public Representative viewRepresentativeProfile(@PathVariable("representativeId") Long representativeId) {
		return viewProfileService.viewRepresentativeProfile(representativeId);
	}
}
