package com.taxfiling.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Notice;
import com.taxfiling.service.ViewNoticeService;

@RestController
public class ViewNoticeController {
	@Autowired
	private ViewNoticeService viewNoticeService;

	@GetMapping("/viewadminnotice/{email_n}")
	public List<Notice> viewadminnotice(@PathVariable("email_n") String email_n) {
		return viewNoticeService.viewadminnotice(email_n);
	}

	@GetMapping("/viewcustomernotice/{customer_id}")
	public List<Notice> viewCustomerNotice(@PathVariable("customer_id") Long id) {
		return viewNoticeService.viewCustomerNotice(id);
	}

	@GetMapping("/viewRepresentativeNotice/{representative_id}")
	public List<Notice> viewRepresentativeNotice(@PathParam("representative_id") Long id) {
		return viewNoticeService.viewRepresentativeNotice(id);
	}
}
