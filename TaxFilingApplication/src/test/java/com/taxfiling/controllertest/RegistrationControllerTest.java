package com.taxfiling.controllertest;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxfiling.TaxFilingApplication;
import com.taxfiling.controller.RegistrationController;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.RegistrationService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TaxFilingApplication.class)
@WebMvcTest(value = RegistrationController.class)
class RegistrationControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RegistrationService regService;

	@Test
	void testRegistercustomer() throws Exception {
		String URI = "/registerCustomer/null";
		Customer cust = new Customer();
		cust.setName("customer123");
		cust.setEmail("cust@gmail.com");
		cust.setPassword("password");
		cust.setSecurityQuestion("3.What is your fathers name?");
		cust.setSecurityAnswer("r");
		cust.setPan("abc12345");
		cust.setContactNo("987654");
		cust.setAccountNo("asdf123");
		// cust.setDateOfBirth(1998-07-08);
		cust.setMaritalStatus("single");
		cust.setAddress("Mumbai");
		cust.setIsEmployee(false);

		String jsonInput = this.convertToJson(cust);

		Mockito.when(regService.registerCustomer(Mockito.any(Customer.class))).thenReturn(new Integer(1));

		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		Assert.assertEquals("Registration successful", jsonOutput);

	}

	@Test
	void testRegisterEmployer() throws Exception {
		String URI = "/registerEmployer";
		Employer emp = new Employer();
		emp.setOrganization("ddfg");
		emp.setEmail("emp@gmail.com");
		emp.setContactNo("987654");
		emp.setPassword("password");
		emp.setSecurityQuestion("3.What is your fathers name?");
		emp.setSecurityAnswer("r");

		String jsonInput = this.convertToJson(emp);

		Mockito.when(regService.registerEmployer(Mockito.any(Employer.class))).thenReturn(new Integer(1));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		Assert.assertEquals("Registration successful", jsonOutput);
	}

	@Test
	void testRegisterRepresentative() throws Exception {
		String URI = "/registerRepresentative";
		Representative rep = new Representative();
		rep.setName("rep123");
		rep.setEmail("rep123@gmail.com");
		rep.setContactNo("987654");
		rep.setPassword("password");
		rep.setSecurityQuestion("3.What is your fathers name?");
		rep.setSecurityAnswer("r");

		String jsonInput = this.convertToJson(rep);

		Mockito.when(regService.registerRepresentative(Mockito.any(Representative.class))).thenReturn(new Integer(1));
		MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		Assert.assertEquals("Registration successful", jsonOutput);
	}

	private String convertToJson(Object rep) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(rep);
	}

}
