package com.taxfiling.entitytest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

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
class EmployerTest {
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
		e = new Employer();
		c = new Customer();
		a = new Admin();
	}

	@AfterEach
	void tearDown() throws Exception {
		e = null;
	}

	@Test
	final void testGetEmployerId() {
		e.setEmployerId(1L);
		assertEquals(1L, e.getEmployerId());
	}

	@Test
	final void testSetEmployerId() {
		e.setEmployerId(1L);
		assertEquals(1L, e.getEmployerId());

	}

	@Test
	final void testGetOrganization() {
		e.setOrganization("Capgemini");
		assertEquals("Capgemini", e.getOrganization());
	}

	@Test
	final void testSetOrganization() {
		e.setOrganization("Capgemini");
		assertEquals("Capgemini", e.getOrganization());
	}

	@Test
	final void testGetEmail() {
		e.setEmail("emp@123");
		assertEquals("emp@123", e.getEmail());

	}

	@Test
	final void testSetEmail() {
		e.setEmail("emp@123");
		assertEquals("emp@123", e.getEmail());

	}

	@Test
	final void testGetPassword() {
		e.setPassword("123");
		assertEquals("123", e.getPassword());

	}

	@Test
	final void testSetPassword() {
		e.setPassword("123");
		assertEquals("123", e.getPassword());

	}

	@Test
	final void testGetSecurityQuestion() {

		e.setSecurityQuestion("What is your name?");
		assertEquals("What is your name?", e.getSecurityQuestion());

	}

	@Test
	final void testSetSecurityQuestion() {
		e.setSecurityQuestion("What is your name?");
		assertEquals("What is your name?", e.getSecurityQuestion());
	}

	@Test
	final void testGetSecurityAnswer() {
		e.setSecurityAnswer("Emp");
		assertEquals("Emp", e.getSecurityAnswer());
	}

	@Test
	final void testSetSecurityAnswer() {

		e.setSecurityAnswer("Emp");
		assertEquals("Emp", e.getSecurityAnswer());
	}

	@Test
	final void testGetContactNo() {
		e.setContactNo("90837474747");
		assertEquals("90837474747", e.getContactNo());
	}

	@Test
	final void testSetContactNo() {
		e.setContactNo("90837474747");
		assertEquals("90837474747", e.getContactNo());
	}

	@Test
	final void testGetCustomers() {
		List<Customer> ll = new ArrayList<Customer>();
		c.setCustomerId(1L);
		c.setAccountNo("123");
		c.setAddress("Pune");
		c.setContactNo("9028737373");
		c.setDateOfBirth(LocalDate.now());
		c.setEmail("Kajal@gmail.com");
		c.setIsEmployee(true);
		c.setMaritalStatus("yes");
		c.setName("Kajal");
		c.setPan("PAN123");
		c.setPassword("123");
		c.setSecurityAnswer("ABC");
		c.setSecurityQuestion("What is your name?");
		c.setAdmin_c(a);
		c.setEmployer(e);
		c.setTaxForm(t);
		ll.add(c);
		e.setCustomers(ll);
		ll = e.getCustomers();
		assertNotNull(ll, "Failed");
	}

	@Test
	final void testSetCustomers() {
		List<Customer> ll = new ArrayList<Customer>();
		c.setCustomerId(1L);
		c.setAccountNo("123");
		c.setAddress("Pune");
		c.setContactNo("9028737373");
		c.setDateOfBirth(LocalDate.now());
		c.setEmail("Kajal@gmail.com");
		c.setIsEmployee(true);
		c.setMaritalStatus("yes");
		c.setName("Kajal");
		c.setPan("PAN123");
		c.setPassword("123");
		c.setSecurityAnswer("ABC");
		c.setSecurityQuestion("What is your name?");
		c.setAdmin_c(a);
		c.setEmployer(e);
		c.setTaxForm(t);
		ll.add(c);
		e.setCustomers(ll);
		ll = e.getCustomers();
		assertNotNull(ll, "Failed");
	}

	@Test
	final void testGetAdmin_e() {
		e.setAdmin_e(a);
		assertNotNull(e.getAdmin_e());

	}

	@Test
	final void testSetAdmin_e() {
		e.setAdmin_e(a);
		// assert e.getAdmin_e()!=null :"passed";
		assertNotNull(e.getAdmin_e());
	}
}