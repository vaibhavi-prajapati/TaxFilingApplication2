package com.taxfiling.repositorytest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.TaxFilingApplication;
import com.taxfiling.entity.Employer;
import com.taxfiling.repository.EmployerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingApplication.class)
public class EmployerRepositoryTest {

	@Autowired
	private EmployerRepository er;

	@Test
	void loginEmployer() {
		Employer e1 = er.loginEmployer(1, "qwe");
		assertEquals("CG", e1.getOrganization());

	}

	@Test
	void findEmployer() {
		Employer e2 = er.findEmployer("CG");
		assertEquals("abc@gmail.com", e2.getEmail());
	}

}