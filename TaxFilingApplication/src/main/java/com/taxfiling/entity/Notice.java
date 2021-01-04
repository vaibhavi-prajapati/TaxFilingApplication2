package com.taxfiling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vaibhavi
 *
 */
@Entity
public class Notice {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long noticeId;

	@NotNull
	@NotBlank(message = "Notice body can not be empty")
	private String noticeBody;

	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@ManyToOne
	@JoinColumn(name = "representativeId_n")
	private Representative representative_n;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "email_n")
	private Admin admin_n;

	public long getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(long noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeBody() {
		return noticeBody;
	}

	public void setNoticeBody(String noticeBody) {
		this.noticeBody = noticeBody;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Representative getRepresentative_n() {
		return representative_n;
	}

	public void setRepresentative_n(Representative representative_n) {
		this.representative_n = representative_n;
	}

	public Admin getAdmin_n() {
		return admin_n;
	}

	public void setAdmin_n(Admin admin_n) {
		this.admin_n = admin_n;
	}
}
