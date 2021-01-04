package com.taxfiling.repositorytest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.TaxFilingApplication;
import com.taxfiling.entity.Representative;
import com.taxfiling.repository.RepresentativeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingApplication.class)
public class RepresentativeRepositoryTest {

	@Autowired
	private RepresentativeRepository rr;

	@Test
	public void loginRepresentative() {
		Representative r = rr.loginRepresentative(1, "Rep@1111");
		Assert.assertEquals("rep", r.getName());
	}
}