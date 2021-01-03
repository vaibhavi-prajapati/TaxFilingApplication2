package com.taxfiling.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.TaxFilingApplication;
import com.taxfiling.entity.Customer;
import com.taxfiling.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingApplication.class)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository cr;

	@Test
	public void getCustByPanTest() {
		Customer c = cr.getCustByPan("asdf");
		assert c.getName().equals("ssk") : "Test Failed";

	}

	@Test
	public void loginCustomerTest() {
		Customer c = cr.loginCustomer((long) 5, "dkdj");
		assert c.getName().equals("ssk");
	}

}
