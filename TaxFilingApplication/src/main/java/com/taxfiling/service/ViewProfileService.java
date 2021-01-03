package com.taxfiling.service;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;

public interface ViewProfileService {

	Customer viewCustomerProfile(Long customerId);

	Employer viewEmployerProfile(Long employerId);

	Representative viewRepresentativeProfile(Long representativeId);
}
