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
import com.taxfiling.service.FileReturnServiceImpl;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
class FileReturnServiceTest {

	@MockBean
	CustomerRepository customerRepository;
	@MockBean
	TaxFormRepository taxformRepository;
	@Autowired
	FileReturnServiceImpl filereturn;

	@Test
	void testFileReturn() {
		TaxForm tf = new TaxForm();
		tf.setTaxformId(1);
		tf.setVerifiedStatus("pending");
		Mockito.when(taxformRepository.fileReturn(tf)).thenReturn(1);
		int i = filereturn.fileReturn(tf);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testGetTaxFromByPan() {
		TaxForm tf = new TaxForm();
		tf.setPan("4521");
		tf.setTaxformId(1);
		Mockito.when(taxformRepository.getTaxFormByPan(tf.getPan())).thenReturn(tf);
		TaxForm tf1 = filereturn.getTaxFromByPan("4521");

		Assert.assertEquals(tf.getTaxformId(), tf1.getTaxformId());

	}

	@Test
	void testGetCustomerById() {
		Customer c = new Customer();
		c.setCustomerId(3);
		c.setPan("4521");
		Mockito.when(customerRepository.findById(c.getCustomerId())).thenReturn(Optional.of(c));
		Customer c1 = filereturn.getCustomerById(3L);
		Assert.assertEquals(c.getPan(), (c1.getPan()));

	}

}