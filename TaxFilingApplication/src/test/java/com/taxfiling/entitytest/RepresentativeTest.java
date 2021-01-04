package com.taxfiling.entitytest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

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
class RepresentativeTest {
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
		r = new Representative();
		a = new Admin();
		n = new Notice();
		t = new TaxForm();
	}

	@AfterEach
	void tearDown() throws Exception {
		r = null;
	}

	@Test
	final void testGetRepresentativeId() {
		r.setRepresentativeId(1l);
		assertEquals(1L, r.getRepresentativeId());
	}

	@Test
	final void testSetRepresentativeId() {

		r.setRepresentativeId(1l);
		assertEquals(1L, r.getRepresentativeId());

	}

	@Test
	final void testGetName() {
		r.setName("Rep");
		assertEquals("Rep", r.getName());
	}

	@Test
	final void testSetName() {

		r.setName("Rep");
		assertEquals("Rep", r.getName());

	}

	@Test
	final void testGetEmail() {
		r.setEmail("Rep@123");
		assertEquals("Rep@123", r.getEmail());
	}

	@Test
	final void testSetEmail() {
		r.setEmail("Rep@123");
		assertEquals("Rep@123", r.getEmail());
	}

	@Test
	final void testGetPassword() {
		r.setPassword("123");
		assertEquals("123", r.getPassword());

	}

	@Test
	final void testSetPassword() {
		r.setPassword("123");
		assertEquals("123", r.getPassword());
	}

	@Test
	final void testGetSecurityQuestion() {
		r.setSecurityQuestion("What is your name?");
		assertEquals("What is your name?", r.getSecurityQuestion());
	}

	@Test
	final void testSetSecurityQuestion() {
		r.setSecurityQuestion("What is your name?");
		assertEquals("What is your name?", r.getSecurityQuestion());
	}

	@Test
	final void testGetSecurityAnswer() {
		r.setSecurityAnswer("Rep");
		assertEquals("Rep", r.getSecurityAnswer());
	}

	@Test
	final void testSetSecurityAnswer() {
		r.setSecurityAnswer("Rep");
		assertEquals("Rep", r.getSecurityAnswer());
	}

	@Test
	final void testGetContactNo() {
		r.setContactNo("908765432");
		assertEquals("908765432", r.getContactNo());
	}

	@Test
	final void testSetContactNo() {

		r.setContactNo("908765432");
		assertEquals("908765432", r.getContactNo());
	}

	@Test
	final void testGetAdmin_r() {
		r.setAdmin_r(a);
		assertNotNull(r.getAdmin_r());
	}

	@Test
	final void testSetAdmin_r() {
		r.setAdmin_r(a);
		assertNotNull(r.getAdmin_r());
	}

	@Test
	final void testGetNotices() {
		List<Notice> ll = new ArrayList<Notice>();
		n.setNoticeId(1L);
		n.setNoticeBody("Your application is approved");
		n.setAdmin_n(a);
		n.setRepresentative_n(r);
		n.setCustomer(c);
		ll.add(n);
		r.setNotices(ll);
		ll = r.getNotices();
		assertNotNull(ll, "Failed");

	}

	@Test
	final void testSetNotices() {
		List<Notice> ll = new ArrayList<Notice>();
		n.setNoticeId(1L);
		n.setNoticeBody("Your application is approved");
		n.setAdmin_n(a);
		n.setRepresentative_n(r);
		n.setCustomer(c);
		ll.add(n);
		r.setNotices(ll);
		ll = r.getNotices();
		assertNotNull(ll, "Failed");

	}

	@Test
	final void testGetTaxForms() {
		List<TaxForm> ll = new ArrayList<TaxForm>();
		t.setTaxformId(1L);
		t.setEducationLoan(20000);
		t.setExtraInfo("No");
		t.setHouseLoan(9000);
		t.setHra(3000);
		t.setInterestIncome(2000);
		t.setMedicalInsurance(4000);
		t.setNps(5000);
		t.setOtherIncome(20000);
		t.setPan("PAN123");
		t.setPayableTax(2000);
		t.setPayableTax(2000);
		t.setPpf(2000);
		t.setRentalIncome(3000);
		t.setSavingsInterest(3000);
		t.setTotalIncomeSalary(2000000);
		t.setTds(2000);
		t.setVerifiedStatus("Approved");
		t.setAdmin_t(a);
		t.setRepresentative_t(r);
		ll.add(t);
		r.setTaxForms(ll);
		ll = r.getTaxForms();
		assertNotNull(ll, "Failed");
	}

	@Test
	final void testSetTaxForms() {

		List<TaxForm> ll = new ArrayList<TaxForm>();
		t.setTaxformId(1L);
		t.setEducationLoan(20000);
		t.setExtraInfo("No");
		t.setHouseLoan(9000);
		t.setHra(3000);
		t.setInterestIncome(2000);
		t.setMedicalInsurance(4000);
		t.setNps(5000);
		t.setOtherIncome(20000);
		t.setPan("PAN123");
		t.setPayableTax(2000);
		t.setPayableTax(2000);
		t.setPpf(2000);
		t.setRentalIncome(3000);
		t.setSavingsInterest(3000);
		t.setTotalIncomeSalary(2000000);
		t.setTds(2000);
		t.setVerifiedStatus("Approved");
		t.setAdmin_t(a);
		t.setRepresentative_t(r);
		ll.add(t);
		r.setTaxForms(ll);
		ll = r.getTaxForms();
		assertNotNull(ll, "Failed");

	}
}