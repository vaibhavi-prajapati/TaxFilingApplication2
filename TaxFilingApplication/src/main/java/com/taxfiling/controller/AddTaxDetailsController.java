package com.taxfiling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.TaxForm;
import com.taxfiling.service.AddTaxDetailsService;

@RestController
public class AddTaxDetailsController {
	@Autowired
	private AddTaxDetailsService ats;

	@PutMapping("/taxDetailsForEmployee")
	public String addTaxDetailsForEmployee(@RequestBody TaxForm objTaxForm) {
		String str = "Taxform details not added";
		int i = ats.addTaxDetailsForEmployeeService(objTaxForm);
		if (i > 0) {
			str = "Taxform details added successfully";
		}
		return str;

	}

	@PutMapping("/taxDetailsByNewCustomer")
	public String addTaxDetailsByNewCustomer(@RequestBody TaxForm objTaxForm) {
		String str = "Taxform details not added";
		int i = ats.addTaxDetailsByNewCustomerService(objTaxForm);
		if (i > 0) {
			str = "Taxform details added successfully(New Customer)";
		}
		return str;
	}

	@PutMapping("/taxDetailsByEmpCustomer")
	public String addTaxDetailsByEmpCustomer(@RequestBody TaxForm objTaxForm) {
		String str = "Taxform details not added";
		int i = ats.addTaxDetailsByEmpCustomerService(objTaxForm);
		if (i > 0) {
			str = "Taxform details added successfully";
		}
		return str;

	}
}
