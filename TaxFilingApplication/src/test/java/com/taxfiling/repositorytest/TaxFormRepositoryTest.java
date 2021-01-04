package com.taxfiling.repositorytest;

import org.junit.Assert;
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
		TaxForm t1 = tr.getTaxFormByPan("VVVVV1234V");
		Long id = t1.getTaxformId();
		Assert.assertEquals("1", id.toString());
	}
}