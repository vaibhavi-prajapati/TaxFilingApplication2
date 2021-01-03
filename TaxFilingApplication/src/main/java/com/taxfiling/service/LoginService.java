package com.taxfiling.service;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;

public interface LoginService {

	Customer loginCustomer(Long customerId, String password);

	Employer loginEmployer(long id, String password);

	Representative loginRepresentative(long id, String password);

	Admin loginAdmin(String id, String password);
}
