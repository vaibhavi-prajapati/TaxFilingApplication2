package com.taxfiling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.taxfiling.controller.LoginController;
import com.taxfiling.entity.Customer;
import com.taxfiling.repository.AdminRepository;
import com.taxfiling.repository.CustomerRepository;
import com.taxfiling.repository.EmployerRepository;
import com.taxfiling.repository.RepresentativeRepository;
import com.taxfiling.service.LoginService;

import junit.framework.Assert;

//@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = TaxFilingApplication.class)
//@WebMvcTest(value = LoginController.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = {LoginController.class,LoginService.class})
class ZLoginControllerTest {


	@Autowired
	private MockMvc mockMvc;
	 
	@MockBean
	private EmployerRepository er;

	@MockBean
	private RepresentativeRepository rr;

	@MockBean
	private CustomerRepository cr;

	@MockBean
	private AdminRepository ar;
	
	 
	@SuppressWarnings("deprecation")
	@Test
	void testLogin() throws Exception {
	String URI="/login/{id},{password},{choice}";
	
	Customer cust=new Customer();
	cust.setCustomerId(1L);
	cust.setPassword("password");
	
	Customer cust1=new Customer();
	cust1.setCustomerId(2L);
	cust1.setPassword("pwd");
	
	Customer cust2=new Customer();
	cust2.setCustomerId(3L);
	cust2.setPassword("pass");
	
	
	Mockito.when(cr.loginCustomer(1L,"password")).thenReturn(cust1);
	Mockito.when(cr.loginCustomer(2L,"pwd")).thenReturn(new Customer());
	Mockito.when(cr.loginCustomer(3L,"pass")).thenReturn(new Customer());
	
	MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI,"1","password",1).accept(MediaType.APPLICATION_JSON)).andReturn();
	
	MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
    String jsonOutput = mockHttpServletResponse.getContentAsString();
    System.out.println(jsonOutput);
     Assert.assertEquals("login succesfull", jsonOutput);
	}
}
