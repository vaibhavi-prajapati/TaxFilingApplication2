package com.taxfiling.repositorytest;

import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.TaxFilingApplication;
import com.taxfiling.entity.Notice;
import com.taxfiling.repository.NoticeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TaxFilingApplication.class)
class NoticeRepositoryTest {

	@Autowired
	private NoticeRepository nr;

	@Test
	void viewadminnotice() {
		List<Notice> n1 = nr.viewadminnotice("admin");
		Assert.assertEquals(2, n1.get(0).getNoticeId());
	}

	@Test
	void viewCustomerNotice() {
		List<Notice> n2 = nr.viewCustomerNotice((long) 1);
		Assert.assertEquals(1, n2.get(0).getNoticeId());
	}

	@Test
	void viewRepresentativeNotice() {
		List<Notice> n3 = nr.viewRepresentativeNotice((long) 1);
		Assert.assertEquals(1, n3.get(0).getNoticeId());
	}
}