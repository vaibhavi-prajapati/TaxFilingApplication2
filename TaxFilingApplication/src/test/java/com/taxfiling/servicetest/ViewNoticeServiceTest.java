package com.taxfiling.servicetest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Notice;
import com.taxfiling.entity.Representative;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.NoticeRepository;
import com.taxfiling.repository.TaxFormRepository;
import com.taxfiling.service.ViewNoticeServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
class ViewNoticeServiceTest {
	@MockBean
	private NoticeRepository noticerepo;
	@MockBean
	private TaxFormRepository taxformrepo;
	@MockBean
	private CustomerRepository customerrepo;
	@Autowired
	ViewNoticeServiceImpl noticeservice;

	@Test
	void testViewadminnotice() {
		Notice n = new Notice();
		n.setNoticeId(1);
		n.setNoticeBody("notice sent");
		Admin a = new Admin();
		a.setEmail("ruhi@gmail.com");
		n.setAdmin_n(a);
		List<Notice> list = new ArrayList<Notice>();
		list.add(n);
		Mockito.when(noticerepo.viewadminnotice(a.getEmail())).thenReturn(list);
		List<Notice> n1 = noticeservice.viewadminnotice("ruhi@gmail.com");
		Assert.assertEquals(n1, (list));

	}

	@Test
	void testViewCustomerNotice() {
		Notice n = new Notice();
		n.setNoticeId(1);
		n.setNoticeBody("notice is sent");
		Customer c = new Customer();
		c.setCustomerId(1);
		n.setCustomer(c);
		List<Notice> list = new ArrayList<Notice>();
		list.add(n);
		Mockito.when(noticerepo.viewCustomerNotice(c.getCustomerId())).thenReturn(list);
		List<Notice> n1 = noticeservice.viewCustomerNotice(1L);
		Assert.assertEquals(n1, (list));

	}

	@Test
	void testViewRepresentativeNotice() {
		Notice n = new Notice();
		n.setNoticeId(1);
		n.setNoticeBody("notice is sent");
		Representative r = new Representative();
		r.setRepresentativeId(1);
		n.setRepresentative_n(r);
		List<Notice> list = new ArrayList<Notice>();
		list.add(n);
		Mockito.when(noticerepo.viewRepresentativeNotice(r.getRepresentativeId())).thenReturn(list);
		List<Notice> n1 = noticeservice.viewRepresentativeNotice(1L);
		Assert.assertEquals(n1, (list));

	}

}