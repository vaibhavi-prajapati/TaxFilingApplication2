package com.taxfiling.controllertest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.taxfiling.TaxFilingApplication;
import com.taxfiling.controller.LoginController;
import com.taxfiling.entity.Customer;
import com.taxfiling.repository.AdminRepository;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.EmployerRepository;
import com.taxfiling.repository.RepresentativeRepository;
import com.taxfiling.service.LoginServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = TaxFilingApplication.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = { LoginController.class, LoginServiceImpl.class })
class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerRepository cr;

	@MockBean
	private EmployerRepository er;

	@MockBean
	private RepresentativeRepository rr;

	@MockBean
	private AdminRepository ar;

	@Test
	void testLogin() throws Exception {
		String URI = "/login/{id}/{password}/{choice}";

		Customer cust = new Customer();
		cust.setCustomerId(1L);
		cust.setPassword("password");

		Customer cust1 = new Customer();
		cust1.setCustomerId(2L);
		cust1.setPassword("pwd");

		Customer cust2 = new Customer();
		cust1.setCustomerId(3L);
		cust1.setPassword("pass");

		Mockito.when(cr.loginCustomer(1L, "password")).thenReturn(cust);
		Mockito.when(cr.loginCustomer(2L, "pwd")).thenReturn(cust1);
		Mockito.when(cr.loginCustomer(3L, "pass")).thenReturn(cust2);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(URI, "2", "pwd", 1).accept(MediaType.APPLICATION_JSON)).andReturn();

		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		Assert.assertEquals("Login Successful", jsonOutput);
	}
}