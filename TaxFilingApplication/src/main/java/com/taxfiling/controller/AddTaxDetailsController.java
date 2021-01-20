package com.taxfiling.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.TaxForm;
import com.taxfiling.service.AddTaxDetailsService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AddTaxDetailsController {

	Logger logger = LoggerFactory.getLogger(AddTaxDetailsController.class);

	@Autowired
	private AddTaxDetailsService addTaxDetailsService;

	@PutMapping("/addTaxDetailsForEmployee")
	public String addTaxDetailsForEmployee(@RequestBody TaxForm objTaxForm) {
		String str = "Taxform details not added";
		LocalDate today = LocalDate.now(); // Today's date
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date2 = LocalDate.parse(objTaxForm.getExtraInfo(), formatter);
		Period p = Period.between(date2, today);
		int age = p.getYears();
		objTaxForm = calculateTax(objTaxForm, age);
		objTaxForm.setTds(objTaxForm.getPayableTax());
		int i = addTaxDetailsService.addTaxDetailsForEmployeeService(objTaxForm);
		if (i > 0) {
			str = "Taxform details added successfully";
		}
		logger.info(str);
		return str;
	}

	@PutMapping("/addTaxDetailsByCustomer")
	public String addTaxDetailsByCustomer(@RequestBody TaxForm objTaxForm) {
		String str = "Taxform details not added";
		Customer c = addTaxDetailsService.getCustomerByPan(objTaxForm.getPan());
		LocalDate today = LocalDate.now(); // Today's date
		Period p = Period.between(c.getDateOfBirth(), today);
		int age = p.getYears();
		int i = 0;
		if (c.getIsEmployee())
			i = addTaxDetailsService.addTaxDetailsByEmpCustomerService(calculateTax(objTaxForm, age));
		else
			i = addTaxDetailsService.addTaxDetailsByNewCustomerService(calculateTax(objTaxForm, age));
		if (i > 0) {
			str = "Taxform details added successfully";
		}
		logger.info(str);
		return str;
	}

	@GetMapping("/getCustomerById/{id}")
	public Customer getCustomerByPan(@PathVariable("id") long customerId) {
		return addTaxDetailsService.getCustomerById(customerId);
	}

	public TaxForm calculateTax(TaxForm objTaxForm, int age) {
		// Gross Total Income
		double gti = objTaxForm.getTotalIncomeSalary() + objTaxForm.getOtherIncome() + objTaxForm.getInterestIncome()
				+ objTaxForm.getRentalIncome();

		// Section 80C
		double d1;
		if (objTaxForm.getPpf() > 150000)
			d1 = 150000;
		else
			d1 = objTaxForm.getPpf();

		// Section 80D
		double d2;
		if (age > 60) {
			if (objTaxForm.getMedicalInsurance() > 50000)
				d2 = 50000;
			else
				d2 = objTaxForm.getMedicalInsurance();

		} else {
			if (objTaxForm.getMedicalInsurance() > 25000)
				d2 = 25000;
			else
				d2 = objTaxForm.getMedicalInsurance();
		}

		// Section 80CCD NPS+APY
		double d3;
		if (objTaxForm.getNps() > 50000)
			d3 = 50000;
		else
			d3 = objTaxForm.getNps();

		// Section 80TTA
		double d4;
		if (objTaxForm.getSavingsInterest() > 10000)
			d4 = 10000;
		else
			d4 = objTaxForm.getSavingsInterest();

		// Section 80EEA
		double d5;
		if (objTaxForm.getHouseLoan() > 200000)
			d5 = 200000;
		else
			d5 = objTaxForm.getHouseLoan();

		// Total Deductions
		double td = d1 + d2 + d3 + d4 + d5;

		// Total taxable income after deductions
		double ti = gti - td;

		// Tax amount
		double tax1 = 0;
		if (age <= 60) {
			if (ti <= 250000)
				tax1 = 0;
			else if (ti > 250000 && ti <= 500000)
				tax1 = 5 / 100.0 * ti;
			else if (ti > 500000 && ti <= 1000000)
				tax1 = 12500 + 0.2 * ti;
			else if (ti > 1000000)
				tax1 = 112500 + (30 / 100.0 * ti);

		} else if (age > 60 && age <= 80) {
			if (ti <= 300000)
				tax1 = 0;
			else if (ti > 300000 && ti <= 500000)
				tax1 = 5 / 100.0 * ti;
			else if (ti > 500000 && ti <= 1000000)
				tax1 = 10000 + (20 / 100.0 * ti);
			else if (ti > 1000000)
				tax1 = 110000 + (30 / 100.0 * ti);

		} else if (age > 80) {
			if (ti <= 500000)
				tax1 = 0;
			else if (ti > 500000 && ti <= 1000000)
				tax1 = 20 / 100.0 * ti;
			else if (ti > 1000000)
				tax1 = 100000 + (30 / 100.0 * ti);

		}
		objTaxForm.setPayableTax(tax1);
		return objTaxForm;
	}
}
