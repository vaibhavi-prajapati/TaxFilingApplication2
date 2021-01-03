package com.taxfiling.service;

import com.taxfiling.entity.TaxForm;

public interface AddTaxDetailsService {

	int addTaxDetailsForEmployeeService(TaxForm objTaxForm);

	int addTaxDetailsByNewCustomerService(TaxForm objTaxForm);

	int addTaxDetailsByEmpCustomerService(TaxForm objTaxForm);
}
