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
import com.taxfiling.service.EditProfileServiceImpl;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
class EditProfileServiceTest {

	@MockBean
	private CustomerRepository customerRepository;
	@MockBean
	private EmployerRepository employerRepository;
	@MockBean
	private RepresentativeRepository representativerepo;
	@MockBean
	private AdminRepository adminrepository;
	@Autowired
	EditProfileServiceImpl editprofile;

	@Test
	void testFindCustomer() {
		Customer c = new Customer();
		c.setCustomerId(3);

		Mockito.when(customerRepository.findById(c.getCustomerId())).thenReturn(Optional.of(c));
		Customer c1 = editprofile.findCustomer(3L);
		Assert.assertEquals(c.getCustomerId(), c1.getCustomerId());

	}

	@Test
	void testUpdateCustomer() {
		Customer c = new Customer();
		c.setName("megha");
		c.setContactNo("9421123935");
		c.setAccountNo("4519");
		c.setAddress("aurangabad");
		c.setIsEmployee(true);
		c.setEmail("megha123@gmail.com");
		c.setMaritalStatus("single");
		c.setPan("4521");
		c.setPassword("megha123");
		c.setSecurityQuestion("what is your nickname?");
		c.setSecurityAnswer("megha");
		c.setDateOfBirth(LocalDate.of(1998, 8, 31));

		Mockito.when(customerRepository.save(Mockito.any(Customer.class))).thenReturn(c);
		int i = editprofile.updateCustomer(c);
		Assert.assertEquals(i, 1);
		// fail("Not yet implemented");
	}

	@Test
	void testFindEmployerByOrg() {
		Employer e = new Employer();
		e.setOrganization("capgemini");
		e.setEmployerId(1);
		Mockito.when(employerRepository.findEmployer(e.getOrganization())).thenReturn(e);
		Employer er = editprofile.findEmployerByOrg("capgemini");

		Assert.assertEquals(e.getEmployerId(), (er.getEmployerId()));
	}

	@Test
	void testFindEmployer() {
		Employer e = new Employer();
		e.setEmployerId(1);

		Mockito.when(employerRepository.findById(e.getEmployerId())).thenReturn(Optional.of(e));
		Employer e1 = editprofile.findEmployer(1L);
		Assert.assertEquals(e.getEmployerId(), e1.getEmployerId());

	}

	@Test
	void testUpdateEmployer() {
		Employer e = new Employer();
		e.setEmail("sejal@gmail.com");
		e.setOrganization("capgemini");
		e.setPassword("sejal@123");
		e.setSecurityAnswer("what is your nickname?");
		e.setSecurityAnswer("sejal");
		e.setContactNo("8668674907");
		Mockito.when(employerRepository.save(e)).thenReturn(e);
		int i = editprofile.updateEmployer(e);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testFindRepresentative() {
		Representative r = new Representative();
		r.setRepresentativeId(1);
		Mockito.when(representativerepo.findById(r.getRepresentativeId())).thenReturn(Optional.of(r));
		Representative r1 = editprofile.findRepresentative(1L);
		Assert.assertEquals(r.getRepresentativeId(), r1.getRepresentativeId());

	}

	@Test
	void testUpdateRepresentative() {
		Representative r = new Representative();
		r.setEmail("tanvi123@gmail.com");
		r.setName("tanvi");
		r.setPassword("tanvi@123");
		r.setSecurityQuestion("what is your nickname?");
		r.setSecurityAnswer("tanu");
		r.setContactNo("78965421323");
		Mockito.when(representativerepo.save(Mockito.any(Representative.class))).thenReturn(r);
		int i = editprofile.updateRepresentative(r);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testFindAdmin() {
		Admin a = new Admin();
		a.setEmail("ruhi@gmail.com");
		Mockito.when(adminrepository.findById(a.getEmail())).thenReturn(Optional.of(a));
		Admin a1 = editprofile.findAdmin("ruhi@gmail.com");
		Assert.assertEquals(a.getEmail(), (a1.getEmail()));

	}

	@Test
	void testUpdateAdmin() {
		Admin a = new Admin();
		a.setEmail("ruhi@gmail.com");
		a.setPassword("ruhi@123");
		Mockito.when(adminrepository.save(Mockito.any(Admin.class))).thenReturn(a);
		int i = editprofile.updateAdmin(a);
		Assert.assertEquals(i, 1);
		// fail("Not yet implemented");
	}

	@Test

	void testRemoveCustomer() {
		Customer c = new Customer();
		c.setCustomerId(3);
		int i = editprofile.removeCustomer(3L);

		Assert.assertEquals(i, 1);

	}

	@Test
	void testRemoveEmployer() {
		Employer e = new Employer();
		e.setEmployerId(1);
		int i = editprofile.removeEmployer(1L);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testRemoveRepresentative() {
		Representative r = new Representative();
		r.setRepresentativeId(1);
		int i = editprofile.removeRepresentative(1L);
		Assert.assertEquals(i, 1);

	}

}