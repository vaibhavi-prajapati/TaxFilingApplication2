package com.taxfiling.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.RegistrationService;

import io.swagger.annotations.ApiOperation;

@RestController
public class RegistrationController {
	@Autowired
	private RegistrationService regService;

	Logger logger = LoggerFactory.getLogger(RegistrationController.class);

	@PostMapping("/registerCustomer/{organizationName}")
	@ApiOperation("If you are not employee put organization name as null")
	public String registercustomer(@RequestBody Customer c, @PathVariable("organizationName") String orgName) {
		String str = "Registration unsuccessful";
		int i = 0;
		Admin a = regService.findAdmin("admin");
		c.setAdmin_c(a);
		if (c.getIsEmployee()) {
			Employer e = regService.findEmployerByOrg(orgName);
			c.setEmployer(e);
		}
		i = regService.registerCustomer(c);
		if (i > 0) {
			str = "Registration successful";
		}
		logger.info("Registration of customer is done successfully");
		return str;
	}

	@PostMapping("/registerEmployer")
	public String registerEmployer(@RequestBody Employer e) {
		String str = "Registration unsuccessful";
		e.setAdmin_e(regService.findAdmin("admin"));
		int i = regService.registerEmployer(e);
		if (i > 0) {
			str = "Registration successful";
		}
		logger.info("Registration of employer is done successfully");
		return str;
	}

	@PostMapping("/registerRepresentative")
	public String registerRepresentative(@RequestBody Representative r) {
		String str = "Registration unsuccessful";
		r.setAdmin_r(regService.findAdmin("admin"));
		int i = regService.registerRepresentative(r);
		if (i > 0) {
			str = "Registration successful";
		}
		logger.info("Registration of employer is done successfully");
		return str;
	}
}
