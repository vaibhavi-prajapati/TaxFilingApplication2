package com.taxfiling.servicetest;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.repository.AdminRepository;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.EmployerRepository;
import com.taxfiling.repository.RepresentativeRepository;
import com.taxfiling.service.RegistrationServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest

class RegistrationServiceTest {

	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	private EmployerRepository employerRepository;
	@MockBean
	private RepresentativeRepository representativeRepository;
	@MockBean
	private AdminRepository adminrepository;

	@Autowired
	RegistrationServiceImpl registrtaionService;

	@Test
	void testRegisterCustomer() {
		Customer c1 = new Customer();
		c1.setName("megha");
		c1.setContactNo("75412963");
		c1.setAccountNo("4519");
		c1.setAddress("aurangabad");
		c1.setIsEmployee(true);
		c1.setEmail("megha@gmail.com");
		c1.setMaritalStatus("single");
		c1.setPan("4521");
		c1.setPassword("megha123");
		c1.setSecurityQuestion("what is your nickname?");
		c1.setSecurityAnswer("megha");
		c1.setDateOfBirth(LocalDate.of(1998, 8, 31));

		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(c1);
		int c = registrtaionService.registerCustomer(c1);

		Assert.assertEquals(c, 1);

	}

	@Test
	void testRegisterEmployer() {
		Employer e = new Employer();
		e.setEmail("sejal123@gmail.com");
		e.setOrganization("capgemini");
		e.setPassword("sejal123");
		e.setSecurityAnswer("what is your nickname?");
		e.setSecurityAnswer("sejal");
		e.setContactNo("34589612");
		Mockito.when(employerRepository.save(Mockito.any(Employer.class))).thenReturn(e);
		int i = registrtaionService.registerEmployer(e);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testRegisterRepresentative() {
		Representative r = new Representative();
		r.setEmail("tanvi@gmail.com");
		r.setName("tanvi");
		r.setPassword("tanvi123");
		r.setSecurityQuestion("what is your nickname?");
		r.setSecurityAnswer("tanu");
		r.setContactNo("78965421323");
		Mockito.when(representativeRepository.save(Mockito.any(Representative.class))).thenReturn(r);
		int i = registrtaionService.registerRepresentative(r);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testFindEmployerByOrg() {
		Employer e = new Employer();
		e.setOrganization("capgemini");
		e.setEmployerId(1);
		Mockito.when(employerRepository.findEmployer(e.getOrganization())).thenReturn(e);
		Employer er = registrtaionService.findEmployerByOrg("capgemini");

		Assert.assertEquals(e.getEmployerId(), (er.getEmployerId()));

	}

	@Test
	void testFindAdmin() {
		Admin a = new Admin();
		a.setEmail("ruhi@gmail.com");
		Mockito.when(adminrepository.findById(a.getEmail())).thenReturn(Optional.of(a));
		Admin aa = registrtaionService.findAdmin("ruhi@gmail.com");

		Assert.assertEquals(a.getEmail(), (aa.getEmail()));

	}

}