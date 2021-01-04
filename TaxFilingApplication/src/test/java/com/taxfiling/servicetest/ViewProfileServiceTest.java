package com.taxfiling.servicetest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;

import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.EmployerRepository;
import com.taxfiling.repository.RepresentativeRepository;
import com.taxfiling.service.ViewProfileServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
class ViewProfileServiceTest {
	@MockBean
	CustomerRepository customerRepository;

	@MockBean
	RepresentativeRepository representativerepository;

	@MockBean
	EmployerRepository employerRepository;
	@Autowired
	ViewProfileServiceImpl viewprofile;

	@Test
	void testViewCustomerProfile() {
		Customer customer = new Customer();
		customer.setCustomerId(3);
		customer.setName("megha");
		customer.setPan("4521");
		Mockito.when(customerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(customer));
		Customer c = viewprofile.viewCustomerProfile(3L);
		Assert.assertEquals(c.getName(), customer.getName());
	}

	@Test
	void testViewEmployerProfile() {
		Employer employer = new Employer();
		employer.setEmployerId(1);
		employer.setEmail("sejal123@gmail.com");
		employer.setPassword("sejal123");
		Mockito.when(employerRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(employer));
		Employer e = viewprofile.viewEmployerProfile(1L);
		Assert.assertEquals(e.getEmail(), employer.getEmail());
	}

	@Test
	void testViewRepresentativeProfile() {
		Representative representative = new Representative();
		representative.setRepresentativeId(1);
		representative.setEmail("tanvi@gmail.com");
		representative.setPassword("tanvi123");
		Mockito.when(representativerepository.findById(Mockito.anyLong())).thenReturn(Optional.of(representative));
		Representative r = viewprofile.viewRepresentativeProfile(1L);
		Assert.assertEquals(r.getEmail(), representative.getEmail());
	}

}