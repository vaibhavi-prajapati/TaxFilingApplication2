package com.taxfiling.service;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;

public interface EditProfileService {
	
	Customer findCustomer(long id);

	int updateCustomer(Customer c);

	Employer findEmployerByOrg(String newOrgName);

	Employer findEmployer(Long id);

	int updateEmployer(Employer e);

	Representative findRepresentative(Long id);

	int updateRepresentative(Representative r);

	Admin findAdmin(String id);

	int updateAdmin(Admin a);

	int removeCustomer(Long id);

	int removeEmployer(Long id);

	int removeRepresentative(Long id);
}
