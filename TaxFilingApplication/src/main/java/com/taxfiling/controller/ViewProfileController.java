package com.taxfiling.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.ViewProfileService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
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

	@GetMapping("/viewAdminProfile/{adminId}")
	@ApiOperation("View Admin Profile")
	public Admin viewAdminProfile() {
		return viewProfileService.viewAdminProfile();
	}

	@GetMapping("/viewAllCustomers")
	public List<Customer> viewAllCustomers() {
		return viewProfileService.viewAllCustomers();
	}

	@GetMapping("/viewAllEmployers")
	public List<Employer> viewAllEmployers() {
		return viewProfileService.viewAllEmployers();
	}

	@GetMapping("/viewAllRepresentatives")
	public List<Representative> viewAllRepresentatives() {
		return viewProfileService.viewAllRepresentatives();
	}

	@GetMapping("/viewAllEmployeesByOrganization/{employerId}")
	public List<Customer> viewAllEmployeesByOrganization(@PathVariable("employerId") long employerId) {
		Employer emp = viewProfileService.viewEmployerProfile(employerId);
		return viewProfileService.viewAllEmployeesByOrganization(emp);
	}
}
