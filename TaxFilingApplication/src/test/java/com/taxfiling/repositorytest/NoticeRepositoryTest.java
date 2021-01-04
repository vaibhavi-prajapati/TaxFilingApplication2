package com.taxfiling.repositorytest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.TaxFilingApplication;
import com.taxfiling.entity.Notice;
import com.taxfiling.repository.NoticeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingApplication.class)
public class NoticeRepositoryTest {
	
	@Autowired
	private NoticeRepository nr;

	@Test
	public void viewadminnotice() {
		List<Notice> n1 = nr.viewadminnotice("sk@cg.com");
		assert n1.get(0).getNoticeBody().equals("Approved") : "Test Failed";
		
	}
	
	@Test
	public void viewCustomerNotice() {
		List<Notice> n2 = nr.viewCustomerNotice((long) 3);
		assert n2.get(0).getNoticeBody().equals("Approved") : "Test Failed";
		
	}
	
	@Test
	public void viewRepresentativeNotice() {
		List<Notice> n3 = nr.viewRepresentativeNotice((long) 1);
		assert n3.get(0).getNoticeBody().equals("Rejected") : "Test Failed";
	}

}