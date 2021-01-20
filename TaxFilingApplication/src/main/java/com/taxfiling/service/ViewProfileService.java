package com.taxfiling.service;

import java.util.List;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;

public interface ViewProfileService {

	Customer viewCustomerProfile(Long customerId);

	Employer viewEmployerProfile(Long employerId);

	Representative viewRepresentativeProfile(Long representativeId);

	List<Customer> viewAllCustomers();

	List<Employer> viewAllEmployers();

	List<Representative> viewAllRepresentatives();

	Admin viewAdminProfile();

	List<Customer> viewAllEmployeesByOrganization(Employer emp);
}
