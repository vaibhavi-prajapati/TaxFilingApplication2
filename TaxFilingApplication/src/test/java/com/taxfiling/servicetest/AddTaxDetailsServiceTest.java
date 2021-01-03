package com.taxfiling.servicetest;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.entity.Customer;
import com.taxfiling.entity.TaxForm;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.TaxFormRepository;
import com.taxfiling.service.AddTaxDetailsServiceImpl;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
class AddTaxDetailsServiceTest {
	@MockBean
	CustomerRepository customerRepository;
	@MockBean
	TaxFormRepository taxformRepository;
	@Autowired
	AddTaxDetailsServiceImpl addtax;

	@Test
	void testAddTaxDetailsForEmployeeService() {
		TaxForm tf = new TaxForm();
		tf.setTaxformId(1);
		tf.setTotalIncomeSalary(14000);
		tf.setOtherIncome(0);
		tf.setInterestIncome(0);
		tf.setRentalIncome(0);
		tf.setPpf(0);
		tf.setMedicalInsurance(0);
		tf.setEducationLoan(0);
		tf.setNps(0);
		tf.setSavingsInterest(0);
		tf.setHouseLoan(0);
		tf.setPayableTax(0);
		tf.setVerifiedStatus("approved");

		Mockito.when(taxformRepository.save(Mockito.any(TaxForm.class))).thenReturn(tf);
		int i = addtax.addTaxDetailsForEmployeeService(tf);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testAddTaxDetailsByNewCustomerService() {
		TaxForm tf = new TaxForm();
		tf.setTaxformId(1);
		tf.setTotalIncomeSalary(14000);
		tf.setOtherIncome(1000);
		tf.setInterestIncome(1000);
		tf.setRentalIncome(0);
		tf.setPpf(0);
		tf.setMedicalInsurance(0);
		tf.setEducationLoan(0);
		tf.setNps(0);
		tf.setSavingsInterest(0);
		tf.setHouseLoan(0);
		tf.setPayableTax(0);
		tf.setVerifiedStatus("approved");
		tf.setPan("4521");
		Mockito.when(taxformRepository.save(Mockito.any(TaxForm.class))).thenReturn(tf);
		Customer c = new Customer();
		c.setTaxForm(tf);

		Mockito.when(customerRepository.getCustByPan(tf.getPan())).thenReturn(c);
		c.setCustomerId(3);
		int i = addtax.addTaxDetailsByNewCustomerService(tf);
		System.out.println("pan is" + c.getPan());
		System.out.println("taxpan is" + tf.getPan());

		Assert.assertEquals(i, 1);

	}

	@Test
	void testAddTaxDetailsByCustomerService() {
		TaxForm tf = new TaxForm();

		tf.setTotalIncomeSalary(14000);
		tf.setOtherIncome(0);
		tf.setInterestIncome(0);
		tf.setRentalIncome(0);
		tf.setPpf(0);
		tf.setMedicalInsurance(0);
		tf.setEducationLoan(0);
		tf.setNps(0);
		tf.setSavingsInterest(0);
		tf.setHouseLoan(0);
		tf.setPayableTax(0);
		tf.setVerifiedStatus("approved");
		tf.setPan("4521");
		Mockito.when(taxformRepository.getTaxFormByPan(tf.getPan())).thenReturn(tf);
		Mockito.when(taxformRepository.findById(tf.getTaxformId())).thenReturn(Optional.of(tf));

		Mockito.when(taxformRepository.save(Mockito.any(TaxForm.class))).thenReturn(tf);
		Customer c = new Customer();
		c.setTaxForm(tf);

		Mockito.when(customerRepository.getCustByPan(tf.getPan())).thenReturn(c);
		c.setCustomerId(3);
		c.setPan("4521");
		int i = addtax.addTaxDetailsByEmpCustomerService(tf);

		Assert.assertEquals(i, 1);
	}
}
