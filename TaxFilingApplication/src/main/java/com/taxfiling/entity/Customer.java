package com.taxfiling.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vaibhavi
 *
 */
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long customerId;

	@NotNull
	@NotBlank(message = "Name can not be empty")
	@Size(min = 2, max = 30)
	private String name;

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
	@NotBlank(message = "PAN can not be empty")
	@Pattern(regexp = "(^$|[A-Z]{5}[0-9]{4}[A-Z]{1})", message = "Enter valid PAN")
	private String pan;

	@NotNull
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Contact number should contain exactly 10 digits")
	private String contactNo;

	@NotNull
	@Pattern(regexp = "(^$|[0-9]{12})", message = "Account number should contain exactly 12 digits")
	private String accountNo;

	@NotNull
	@JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
	@Past(message = "Date of Birth can not be in future")
	private LocalDate dateOfBirth;

	private String maritalStatus;
	private String address;

	@NotNull
	private boolean isEmployee;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employerId")
	private Employer employer;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "email_c")
	private Admin admin_c;

	@OneToOne
	@JoinColumn(name = "taxFormId")
	private TaxForm taxForm;

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Notice> notices;

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public boolean getIsEmployee() {
		return isEmployee;
	}

	public void setIsEmployee(boolean isEmployee) {
		this.isEmployee = isEmployee;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Admin getAdmin_c() {
		return admin_c;
	}

	public void setAdmin_c(Admin admin_c) {
		this.admin_c = admin_c;
	}

	public TaxForm getTaxForm() {
		return taxForm;
	}

	public void setTaxForm(TaxForm taxForm) {
		this.taxForm = taxForm;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}
}
