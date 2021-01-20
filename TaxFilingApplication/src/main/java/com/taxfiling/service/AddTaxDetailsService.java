package com.taxfiling.service;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.TaxForm;

public interface AddTaxDetailsService {

	int addTaxDetailsForEmployeeService(TaxForm objTaxForm);

	int addTaxDetailsByNewCustomerService(TaxForm objTaxForm);

	int addTaxDetailsByEmpCustomerService(TaxForm objTaxForm);

	Customer getCustomerByPan(String pan);
	
	Customer getCustomerById(long customerId);
}
