package com.taxfiling.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vaibhavi
 *
 */
@Entity
public class Employer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employerId;

	@NotNull
	@NotBlank(message = "Organization name can not be empty")
	@Size(min = 2, max = 30)
	private String organization;

	@NotNull(message = "Email can not be empty")
	@Column(unique = true)
	@Email(message = "Enter valid email id")
	private String email;

	@NotNull
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", message = "Password must contain minimum 8 characters, at least 1 uppercase letter, 1 lowercase letter, 1 number and 1 special character")
	private String password;

	@NotNull
	@NotBlank(message = "Security question can not be empty")
	private String securityQuestion;

	@NotNull
	@NotBlank(message = "Security answer can not be empty")
	private String securityAnswer;

	@NotNull
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Contact number should contain exactly 10 digits")
	private String contactNo;

	@JsonIgnore
	@OneToMany(mappedBy = "employer")
	private List<Customer> customers;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "email_e")
	private Admin admin_e;

	public long getEmployerId() {
		return employerId;
	}

	public void setEmployerId(long employerId) {
		this.employerId = employerId;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

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

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Admin getAdmin_e() {
		return admin_e;
	}

	public void setAdmin_e(Admin admin_e) {
		this.admin_e = admin_e;
	}
}
