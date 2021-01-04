package com.taxfiling.repositorytest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.TaxFilingApplication;
import com.taxfiling.entity.TaxForm;
import com.taxfiling.repository.TaxFormRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingApplication.class)
public class TaxFormRepositoryTest {

	@Autowired
	private TaxFormRepository tr;

	@Test
	public void getTaxFormByPan() {
		TaxForm t1 = tr.getTaxFormByPan("asdf");
		double tt = t1.getTotalIncomeSalary();
		assert tt == 1500000 : "Test Failed";

	}
}