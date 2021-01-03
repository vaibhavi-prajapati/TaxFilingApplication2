package com.taxfiling.controllertest;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taxfiling.TaxFilingApplication;
import com.taxfiling.controller.ViewNoticeController;
import com.taxfiling.entity.Notice;
import com.taxfiling.service.ViewNoticeService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@ContextConfiguration(classes = TaxFilingApplication.class)
@ExtendWith(SpringExtension.class)
@WebMvcTest(value = { ViewNoticeController.class, ViewNoticeService.class })
class ViewNoticeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ViewNoticeService noticeService;

	@Test
	void testViewadminnotice() throws Exception {

		String URI = "/viewadminnotice/{email_n}";

		List<Notice> ll = new ArrayList<Notice>();

		Notice n1 = new Notice();
		n1.setNoticeBody("rejected");
		n1.setNoticeId(1L);
		ll.add(n1);

		Mockito.when(noticeService.viewadminnotice("admin@gmail.com")).thenReturn(ll);

		String jsonInput = this.convertToJson(ll);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(URI, "admin@gmail.com").accept(MediaType.APPLICATION_JSON))
				.andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		Assert.assertEquals(jsonInput, jsonOutput);

	}

	@Test
	void testViewCustomerNotice() throws Exception {

		String URI = "/viewcustomernotice/{customer_id}";

		List<Notice> ll = new ArrayList<Notice>();

		Notice n1 = new Notice();
		n1.setNoticeBody("rejected");
		n1.setNoticeId(1L);
		ll.add(n1);

		Mockito.when(noticeService.viewCustomerNotice(1L)).thenReturn(ll);

		String jsonInput = this.convertToJson(ll);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(URI, 1L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		Assert.assertEquals(jsonInput, jsonOutput);

	}

	@Test
	void testViewRepresentativeNotice() throws Exception {
		String URI = "/viewRepresentativeNotice/{representative_id}";

		List<Notice> ll = new ArrayList<Notice>();

		Notice n1 = new Notice();
		n1.setNoticeBody("rejected");
		n1.setNoticeId(1L);
		ll.add(n1);

		Mockito.when(noticeService.viewRepresentativeNotice(1L)).thenReturn(ll);

		String jsonInput = this.convertToJson(ll);

		MvcResult mvcResult = this.mockMvc
				.perform(MockMvcRequestBuilders.get(URI, 1L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		String jsonOutput = mockHttpServletResponse.getContentAsString();
		Assert.assertEquals(jsonInput, jsonOutput);

	}

	private String convertToJson(Object rep) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.writeValueAsString(rep);
	}

}