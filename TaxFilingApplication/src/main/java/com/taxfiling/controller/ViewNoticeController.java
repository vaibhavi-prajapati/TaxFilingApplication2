package com.taxfiling.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Notice;
import com.taxfiling.service.ViewNoticeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class ViewNoticeController {

	Logger logger = LoggerFactory.getLogger(ViewNoticeController.class);

	@Autowired
	private ViewNoticeService viewNoticeService;

	@GetMapping("/viewadminnotice/{email_n}")
	@ApiOperation("Enter the admin Id")
	public List<Notice> viewAdminNotices(@PathVariable("email_n") String email_n) {
		return viewNoticeService.viewadminnotice(email_n);
	}

	@GetMapping("/viewcustomernotice/{customer_id}")
	@ApiOperation("Enter the customer Id")
	public List<Notice> viewCustomerNotices(@PathVariable("customer_id") Long id) {
		return viewNoticeService.viewCustomerNotice(id);
	}

	@GetMapping("/viewRepresentativeNotice/{representative_id}")
	@ApiOperation("Enter the representative Id")
	public List<Notice> viewRepresentativeNotices(@PathVariable("representative_id") Long id) {
		return viewNoticeService.viewRepresentativeNotice(id);
	}
}
