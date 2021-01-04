package com.taxfiling.entitytest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

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
class TaxFormTest {
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
		t = new TaxForm();
		a = new Admin();
		c = new Customer();
		r = new Representative();

	}

	@AfterEach
	void tearDown() throws Exception {
		t = null;
	}

	@Test
	final void testGetTaxformId() {
		t.setTaxformId(1L);
		assertEquals(1L, t.getTaxformId());
	}

	@Test
	final void testSetTaxformId() {

		t.setTaxformId(1L);
		assertEquals(1L, t.getTaxformId());

	}

	@Test
	final void testGetPan() {

		t.setPan("PAN123");
		assertEquals("PAN123", t.getPan());
	}

	@Test
	final void testSetPan() {
		t.setPan("PAN123");
		assertEquals("PAN123", t.getPan());

	}

	@Test
	final void testGetTotalIncomeSalary() {
		t.setTotalIncomeSalary(50000);
		assertEquals(50000, t.getTotalIncomeSalary());
	}

	@Test
	final void testSetTotalIncomeSalary() {

		t.setTotalIncomeSalary(50000);
		assertEquals(50000, t.getTotalIncomeSalary());
	}

	@Test
	final void testGetHra() {

		t.setHra(2000);
		assertEquals(2000, t.getHra());
	}

	@Test
	final void testSetHra() {
		t.setHra(2000);
		assertEquals(2000, t.getHra());
	}

	@Test
	final void testGetOtherIncome() {

		t.setOtherIncome(20000);
		assertEquals(20000, t.getOtherIncome());
	}

	@Test
	final void testSetOtherIncome() {

		t.setOtherIncome(20000);
		assertEquals(20000, t.getOtherIncome());
	}

	@Test
	final void testGetInterestIncome() {

		t.setInterestIncome(2000);
		assertEquals(2000, t.getInterestIncome());

	}

	@Test
	final void testSetInterestIncome() {
		t.setInterestIncome(2000);
		assertEquals(2000, t.getInterestIncome());
	}

	@Test
	final void testGetRentalIncome() {
		t.setRentalIncome(20000);
		assertEquals(20000, t.getRentalIncome());
	}

	@Test
	final void testSetRentalIncome() {
		t.setRentalIncome(20000);
		assertEquals(20000, t.getRentalIncome());

	}

	@Test
	final void testGetPpf() {
		t.setPpf(2000);
		assertEquals(2000, t.getPpf());

	}

	@Test
	final void testSetPpf() {
		t.setPpf(2000);
		assertEquals(2000, t.getPpf());
	}

	@Test
	final void testGetMedicalInsurance() {

		t.setMedicalInsurance(2000);
		assertEquals(2000, t.getMedicalInsurance());
	}

	@Test
	final void testSetMedicalInsurance() {

		t.setMedicalInsurance(2000);
		assertEquals(2000, t.getMedicalInsurance());
	}

	@Test
	final void testGetEducaionLoan() {

		t.setEducationLoan(20000);
		assertEquals(20000, t.getEducationLoan());
	}

	@Test
	final void testSetEducaionLoan() {

		t.setEducationLoan(20000);

		assertEquals(20000, t.getEducationLoan());
	}

	@Test
	final void testGetHouseLoan() {
		t.setHouseLoan(20000);

		assertEquals(20000, t.getHouseLoan());
	}

	@Test
	final void testSetHouseLoan() {
		t.setHouseLoan(20000);

		assertEquals(20000, t.getHouseLoan());
	}

	@Test
	final void testGetNps() {

		t.setNps(2000);
		assertEquals(2000, t.getNps());
	}

	@Test
	final void testSetNps() {
		t.setNps(2000);
		assertEquals(2000, t.getNps());
	}

	@Test
	final void testGetSavingsInterest() {
		t.setSavingsInterest(2000);
		assertEquals(2000, t.getSavingsInterest());
	}

	@Test
	final void testSetSavingsInterest() {
		t.setSavingsInterest(2000);
		assertEquals(2000, t.getSavingsInterest());
	}

	@Test
	final void testGetTds() {

		t.setTds(2000);
		assertEquals(2000, t.getTds());
	}

	@Test
	final void testSetTds() {

		t.setTds(2000);
		assertEquals(2000, t.getTds());

	}

	@Test
	final void testGetPayableTax() {

		t.setPayableTax(2000);
		assertEquals(2000, t.getPayableTax());

	}

	@Test
	final void testSetPayableTax() {
		t.setPayableTax(2000);
		assertEquals(2000, t.getPayableTax());
	}

	@Test
	final void testGetExtraInfo() {

		t.setExtraInfo("Nothing");
		assertEquals("Nothing", t.getExtraInfo());
	}

	@Test
	final void testSetExtraInfo() {

		t.setExtraInfo("Nothing");
		assertEquals("Nothing", t.getExtraInfo());
	}

	@Test
	final void testGetVerifiedStatus() {
		t.setVerifiedStatus("No");
		assertEquals("No", t.getVerifiedStatus());
	}

	@Test
	final void testSetVerifiedStatus() {
		t.setVerifiedStatus("No");
		assertEquals("No", t.getVerifiedStatus());
	}

	@Test
	final void testGetCustomer() {
		t.setCustomer(c);
		assertNotNull(t.getCustomer());
	}

	@Test
	final void testSetCustomer() {

		t.setCustomer(c);
		assertNotNull(t.getCustomer());
	}

	@Test
	final void testGetAdmin_t() {

		t.setAdmin_t(a);
		assertNotNull(t.getAdmin_t());
	}

	@Test
	final void testSetAdmin_t() {
		t.setAdmin_t(a);
		assertNotNull(t.getAdmin_t());
	}

	@Test
	final void testGetRepresentative_t() {

		t.setRepresentative_t(r);
		assertNotNull(t.getRepresentative_t());
	}

	@Test
	final void testSetRepresentative_t() {
		t.setRepresentative_t(r);
		assertNotNull(t.getRepresentative_t());
	}
}