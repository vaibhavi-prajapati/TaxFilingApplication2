package com.taxfiling.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vaibhavi
 *
 */
@Entity
public class Admin {
	@Id
	@Email(message = "Email can not be empty")
	private String email;

	private String password;

	@JsonIgnore
	@OneToMany(mappedBy = "admin_c", cascade = CascadeType.ALL)
	private List<Customer> customers;

	@JsonIgnore
	@OneToMany(mappedBy = "admin_r", cascade = CascadeType.ALL)
	private List<Representative> representatives;

	@JsonIgnore
	@OneToMany(mappedBy = "admin_e", cascade = CascadeType.ALL)
	private List<Employer> employers;

	@JsonIgnore
	@OneToMany(mappedBy = "admin_t", cascade = CascadeType.ALL)
	private List<TaxForm> taxForm;

	@JsonIgnore
	@OneToMany(mappedBy = "admin_n", cascade = CascadeType.ALL)
	private List<Notice> notices;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public List<Representative> getRepresentatives() {
		return representatives;
	}

	public void setRepresentatives(List<Representative> representatives) {
		this.representatives = representatives;
	}

	public List<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}

	public List<TaxForm> getTaxForm() {
		return taxForm;
	}

	public void setTaxForm(List<TaxForm> taxForm) {
		this.taxForm = taxForm;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
}
