package com.taxfiling.servicetest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import com.taxfiling.entity.TaxForm;
import com.taxfiling.repository.AdminRepository;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.NoticeRepository;
import com.taxfiling.repository.RepresentativeRepository;
import com.taxfiling.repository.TaxFormRepository;
import com.taxfiling.service.FileReturnServiceImpl;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@SpringBootTest
class FileReturnServiceTest {

	@MockBean
	CustomerRepository customerRepository;
	@MockBean
	TaxFormRepository taxformRepository;
	@MockBean
	RepresentativeRepository representativerepository;
	@MockBean
	AdminRepository adminrepository;
	@MockBean
	NoticeRepository noticerepository;
	@Autowired
	FileReturnServiceImpl filereturn;

	@Test
	void testFileReturn() {
		TaxForm tf = new TaxForm();
		tf.setTaxformId(1);
		tf.setVerifiedStatus("pending");
		Mockito.when(taxformRepository.fileReturn(tf)).thenReturn(1);
		int i = filereturn.fileReturn(tf);
		Assert.assertEquals(i, 1);

	}

	@Test
	void testGetTaxFromByPan() {
		TaxForm tf = new TaxForm();
		tf.setPan("4521");
		tf.setTaxformId(1);
		Mockito.when(taxformRepository.getTaxFormByPan(tf.getPan())).thenReturn(tf);
		TaxForm tf1 = filereturn.getTaxFromByPan("4521");

		Assert.assertEquals(tf.getTaxformId(), tf1.getTaxformId());

	}

	@Test
	void testGetCustomerById() {
		Customer c = new Customer();
		c.setCustomerId(3);
		c.setPan("4521");
		Mockito.when(customerRepository.findById(c.getCustomerId())).thenReturn(Optional.of(c));
		Customer c1 = filereturn.getCustomerById(3L);
		Assert.assertEquals(c.getPan(), (c1.getPan()));

	}

	@Test
	void getTaxFormsForRepresentative() {
		TaxForm taxform = new TaxForm();
		taxform.setTaxformId(1);
		taxform.setVerifiedStatus("pending");
		Representative representative = new Representative();
		representative.setRepresentativeId(1);
		List<TaxForm> list = new ArrayList<TaxForm>();
		list.add(taxform);
		representative.setTaxForms(list);
		taxform.setRepresentative_t(representative);
		Mockito.when(taxformRepository.getTaxFormsForRepresentative()).thenReturn(list);
		List<TaxForm> list1 = filereturn.getTaxFormsForRepresentative();
		Assert.assertEquals(list1, list);

	}

	@Test
	void getCustomerByTaxFormId() {
		Customer customer = new Customer();
		customer.setCustomerId(3);
		customer.setName("megha");
		TaxForm taxform = new TaxForm();
		taxform.setCustomer(customer);
		customer.setTaxForm(taxform);
		Mockito.when(customerRepository.getCustomerByTaxFormId(customer.getCustomerId())).thenReturn(customer);
		Customer customer1 = filereturn.getCustomerByTaxFormId(3L);
		Assert.assertEquals(customer.getName(), customer1.getName());

	}

	@Test
	void getRepresentativeById() {
		Representative representative = new Representative();
		representative.setRepresentativeId(1);
		representative.setName("tanvi");
		Mockito.when(representativerepository.findById(representative.getRepresentativeId()))
				.thenReturn(Optional.of(representative));
		Representative r1 = filereturn.getRepresentativeById(1L);
		Assert.assertEquals(r1.getName(), representative.getName());
	}

	@Test
	void addNotice() {
		Notice notice = new Notice();
		notice.setNoticeId(1);
		notice.setNoticeBody("notice is sent");
		Mockito.when(noticerepository.save(Mockito.any(Notice.class))).thenReturn(notice);
		int n = filereturn.addNotice(notice);
		Assert.assertEquals(n, 1);

	}

	@Test
	void updateTaxForm() {
		TaxForm taxform = new TaxForm();
		taxform.setTaxformId(1);
		taxform.setVerifiedStatus("approved");
		Mockito.when(taxformRepository.updateTaxForm(Mockito.anyLong(), Mockito.anyString())).thenReturn(1);
		int i = filereturn.updateTaxForm(1L, "approved");
		Assert.assertEquals(i, 1);

	}

	@Test
	void getAdmin() {
		Admin admin = new Admin();
		admin.setEmail("ruhi@gmail.com");
		admin.setPassword("ruhi@123");
		Mockito.when(adminrepository.findById("admin")).thenReturn(Optional.of(admin));
		Admin a = filereturn.getAdmin();

		Assert.assertEquals(a.getPassword(), admin.getPassword());
	}

	@Test
	void getTaxFormsForAdmin() {
		TaxForm taxform = new TaxForm();
		taxform.setTaxformId(1);
		taxform.setVerifiedStatus("approvePending");
		Admin admin = new Admin();
		admin.setEmail("ruhi@gmail.com");
		List<TaxForm> list = new ArrayList<TaxForm>();
		list.add(taxform);
		admin.setTaxForm(list);
		taxform.setAdmin_t(admin);
		Mockito.when(taxformRepository.getTaxFormsForAdmin()).thenReturn(list);
		List<TaxForm> list1 = filereturn.getTaxFormsForAdmin();
		Assert.assertEquals(list, list1);
	}

}