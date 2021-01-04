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
public class Representative {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long representativeId;

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
	@Pattern(regexp = "(^$|[0-9]{10})", message = "Contact number should contain exactly 10 digits")
	private String contactNo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "email_r")
	private Admin admin_r;

	@JsonIgnore
	@OneToMany(mappedBy = "representative_n")
	private List<Notice> notices;

	@JsonIgnore
	@OneToMany(mappedBy = "representative_t")
	private List<TaxForm> taxForms;

	public long getRepresentativeId() {
		return representativeId;
	}

	public void setRepresentativeId(long representativeId) {
		this.representativeId = representativeId;
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

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Admin getAdmin_r() {
		return admin_r;
	}

	public void setAdmin_r(Admin admin_r) {
		this.admin_r = admin_r;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public List<TaxForm> getTaxForms() {
		return taxForms;
	}

	public void setTaxForms(List<TaxForm> taxForms) {
		this.taxForms = taxForms;
	}
}
