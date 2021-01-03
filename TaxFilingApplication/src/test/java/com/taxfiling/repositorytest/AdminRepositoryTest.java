package com.taxfiling.repositorytest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.TaxFilingApplication;
import com.taxfiling.entity.Admin;
import com.taxfiling.repository.AdminRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingApplication.class)
class AdminRepositoryTest {

	@Autowired
	private AdminRepository ar;

	@Test
	void getloginAdmin() {
		Admin a3 = ar.loginAdmin("sk@cg.com", "sk123");
		assert a3.getEmail().equals("sk@cg.com") : "Test Failed";
	}
}