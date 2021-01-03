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
import com.taxfiling.controller.EditProfileController;
import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.EditProfileService;
import com.taxfiling.service.EditProfileServiceImpl;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = TaxFilingApplication.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = { EditProfileController.class, EditProfileServiceImpl.class })
class EditProfileControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EditProfileService editService;

	@Test
	void testUpadteCustomer() throws Exception {

		String URI = "/editCustomer/{id}/{editChoice}/{newValue}";

		Customer cust = new Customer();
		cust.setCustomerId(1L);
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

		Mockito.when(editService.updateCustomer(cust)).thenReturn(new Integer(1));
		Mockito.when(editService.findCustomer(1L)).thenReturn(cust);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.put(URI, 1L, 1, "sanket").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		Assert.assertEquals("Your field Name with updated value is sanket", jsonOutput);

	}

	@Test
	void testUpadteEmployer() throws Exception {
		String URI = "/editEmployer/{id}/{editChoice}/{newValue}";
		Employer emp = new Employer();

		emp.setEmployerId(1L);
		emp.setOrganization("deloitte");
		emp.setEmail("deloitte@gmail.com");
		emp.setPassword("password");
		emp.setSecurityQuestion("3.What is your fathers name?");
		emp.setSecurityAnswer("r");
		emp.setContactNo("9876543210");

		Mockito.when(editService.updateEmployer(emp)).thenReturn(new Integer(1));
		Mockito.when(editService.findEmployer(1L)).thenReturn(emp);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.put(URI, 1L, 2, "pass").accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		Assert.assertEquals("Your field Password with updated value is pass", jsonOutput);

	}

	@Test
	void testUpadteRepresentative() throws Exception {
		String URI = "/editRepresentative/{id},{editChoice},{newValue}";

		Representative rep = new Representative();

		rep.setRepresentativeId(1L);
		rep.setName("rep1");
		rep.setEmail("rep1@gmail.com");
		rep.setPassword("password");
		rep.setSecurityQuestion("3.What is your fathers name?");
		rep.setSecurityAnswer("r");
		rep.setContactNo("9876543210");

		Mockito.when(editService.updateRepresentative(rep)).thenReturn(new Integer(1));
		Mockito.when(editService.findRepresentative(1L)).thenReturn(rep);
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.put(URI, 1L, 3, "pass").accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		Assert.assertEquals("Your field Password with updated value is pass", jsonOutput);

	}

	@Test
	void testUpadteAdmin() throws Exception {
		String URI = "/editAdmin/{id},{editChoice},{newValue}";

		Admin a = new Admin();
		a.setEmail("admin@gmail.com");
		a.setPassword("password");

		Mockito.when(editService.updateAdmin(a)).thenReturn(new Integer(1));
		Mockito.when(editService.findAdmin("admin@gmail.com")).thenReturn(a);
		MvcResult mvcResult = this.mockMvc.perform(
				MockMvcRequestBuilders.put(URI, "admin@gmail.com", 1, "pass").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();

		Assert.assertEquals("Your field Password with updated value is pass", jsonOutput);

	}

	@Test
	void testRemoveActor() throws Exception {
		String URI = "/removeActor/{userChoice}/{id}";

		Representative rep = new Representative();

		rep.setRepresentativeId(1L);
		rep.setName("rep1");
		rep.setEmail("rep1@gmail.com");
		rep.setPassword("password");
		rep.setSecurityQuestion("3.What is your fathers name?");
		rep.setSecurityAnswer("r");
		rep.setContactNo("9876543210");

		Mockito.when(editService.removeRepresentative(1L)).thenReturn(new Integer(1));
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.delete(URI, 3, 1L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		Assert.assertEquals("Representative with id 1 has been deleted succesfully", jsonOutput);

	}

	@Test
	void testForgotPassword() throws Exception {
		String URI = "/forgotPassword/{id},{userChoice},{questionChoice},{answer},{newPassword}";

		Representative rep = new Representative();

		rep.setRepresentativeId(1L);
		rep.setName("rep1");
		rep.setEmail("rep1@gmail.com");
		rep.setPassword("password");
		rep.setSecurityQuestion("3.What is your fathers name?");
		rep.setSecurityAnswer("r");
		rep.setContactNo("9876543210");

		Mockito.when(editService.findRepresentative(1L)).thenReturn(rep);
		Mockito.when(editService.updateRepresentative(rep)).thenReturn(new Integer(1));
		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.put(URI, 1L, 3, 3, "r", "pass").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		Assert.assertEquals("Password resetted succesfully", jsonOutput);
	}

}
