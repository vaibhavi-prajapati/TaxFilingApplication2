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
	public void loginEmployer() {
		Employer e1 = er.loginEmployer(1, "Emp@1111");
		assertEquals("capg", e1.getOrganization());
	}

	@Test
	public void findEmployer() {
		Employer e2 = er.findEmployer("capg");
		assertEquals("emp@gmail.com", e2.getEmail());
	}
}