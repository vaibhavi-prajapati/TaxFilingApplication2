package com.taxfiling.entitytest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.entity.*;
import com.taxfiling.repository.AdminRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AdminTest {
	@Autowired
	AdminRepository aa;
	Admin a;
	Customer c;
	Representative r;
	Notice n;
	TaxForm t;
	Employer e;

	@BeforeEach
	void setUp() throws Exception {
		a = new Admin();
		c = new Customer();
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
	}

	@Test
	final void testGetEmail() {
		a.setEmail("Kajal@123");
		assertEquals("Kajal@123", a.getEmail());

	}

	@Test
	final void testSetEmail() {

		a.setEmail("Kajal@123");
		assertEquals("Kajal@123", a.getEmail());
	}

	@Test
	final void testGetPassword() {
		a.setPassword("123");
		assertEquals("123", a.getPassword());
	}

	@Test
	final void testSetPassword() {
		a.setPassword("123");
		assertEquals("123", a.getPassword());
	}

	@Test
	final void testGetCustomer() {
		// List<Customer> ll1=new ArrayList<Customer>();
		List<Customer> ll = new ArrayList<Customer>();
		c.setCustomerId(1L);
		c.setAccountNo("acc12");
		c.setAddress("Pune");
		c.setContactNo("982828229");
		c.setDateOfBirth(LocalDate.now());
		c.setEmail("Kajal@12");
		c.setIsEmployee(true);
		c.setMaritalStatus("No");
		c.setName("Kajal");
		c.setPan("PAN123");
		c.setPassword("123");
		c.setSecurityAnswer("Kajal");
		c.setSecurityQuestion("What is your name?");
		c.setEmployer(e);
		c.setAdmin_c(a);
		c.setTaxForm(t);
		ll.add(c);
		a.setCustomers(ll);
		ll = a.getCustomers();
		assertNotNull(ll, "Failed");
	}

	@Test
	final void testSetCustomer() {

		List<Customer> ll = new ArrayList<Customer>();
		c.setCustomerId(1L);
		c.setAccountNo("acc12");
		c.setAddress("Pune");
		c.setContactNo("982828229");
		c.setDateOfBirth(LocalDate.now());
		c.setEmail("Kajal@12");
		c.setIsEmployee(true);
		c.setMaritalStatus("No");
		c.setName("Kajal");
		c.setPan("PAN123");
		c.setPassword("123");
		c.setSecurityAnswer("Kajal");
		c.setSecurityQuestion("What is your name?");
		c.setEmployer(e);
		c.setAdmin_c(a);
		c.setTaxForm(t);
		ll.add(c);
		a.setCustomers(ll);

		ll = a.getCustomers();

		assertNotNull(ll, "Failed");

	}

}