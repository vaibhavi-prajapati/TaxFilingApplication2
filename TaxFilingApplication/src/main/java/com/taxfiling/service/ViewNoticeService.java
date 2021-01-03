package com.taxfiling.service;

import java.util.List;

import com.taxfiling.entity.Notice;

public interface ViewNoticeService {

	public List<Notice> viewadminnotice(String email);

	public List<Notice> viewCustomerNotice(Long id);

	public List<Notice> viewRepresentativeNotice(Long id);
}
