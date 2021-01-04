package com.taxfiling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Vaibhavi
 *
 */
@Entity
public class TaxForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long taxformId;

	@NotNull
	@NotBlank(message = "PAN can not be empty")
	@Pattern(regexp = "(^$|[A-Z]{5}[0-9]{4}[A-Z]{1})", message = "Enter valid PAN")
	private String pan;

	@NotNull
	@PositiveOrZero(message = "Total Income Salary must be greater than or equal to 0")
	private double totalIncomeSalary;

	@NotNull
	@PositiveOrZero(message = "HRA must be greater than or equal to 0")
	private double hra;

	@NotNull
	@PositiveOrZero(message = "Other income must be greater than or equal to 0")
	private double otherIncome;

	@NotNull
	@PositiveOrZero(message = "Interest Income must be greater than or equal to 0")
	private double interestIncome;

	@NotNull
	@PositiveOrZero(message = "REntal Income must be greater than or equal to 0")
	private double rentalIncome;

	@NotNull
	@PositiveOrZero(message = "PPF must be greater than or equal to 0")
	private double ppf;

	@NotNull
	@PositiveOrZero(message = "Medical Insurance must be greater than or equal to 0")
	private double medicalInsurance;

	@NotNull
	@PositiveOrZero(message = "Education Loan must be greater than or equal to 0")
	private double educationLoan;

	@NotNull
	@PositiveOrZero(message = "House Loan must be greater than or equal to 0")
	private double houseLoan;

	@NotNull
	@PositiveOrZero(message = "NPS must be greater than or equal to 0")
	private double nps;

	@NotNull
	@PositiveOrZero(message = "Savings Interest must be greater than or equal to 0")
	private double savingsInterest;

	@NotNull
	@PositiveOrZero(message = "TDS must be greater than or equal to 0")
	private double tds;

	@NotNull
	@PositiveOrZero(message = "Payable Tax must be greater than or equal to 0")
	private double payableTax;

	@NotNull
	private String extraInfo;

	@NotNull
	@NotBlank
	private String verifiedStatus;

	@JsonIgnore
	@OneToOne(mappedBy = "taxForm")
	private Customer customer;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "representativeId_t")
	private Representative representative_t;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "email_t")
	private Admin admin_t;

	public long getTaxformId() {
		return taxformId;
	}

	public void setTaxformId(long taxformId) {
		this.taxformId = taxformId;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public double getTotalIncomeSalary() {
		return totalIncomeSalary;
	}

	public void setTotalIncomeSalary(double totalIncomeSalary) {
		this.totalIncomeSalary = totalIncomeSalary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getOtherIncome() {
		return otherIncome;
	}

	public void setOtherIncome(double otherIncome) {
		this.otherIncome = otherIncome;
	}

	public double getInterestIncome() {
		return interestIncome;
	}

	public void setInterestIncome(double interestIncome) {
		this.interestIncome = interestIncome;
	}

	public double getRentalIncome() {
		return rentalIncome;
	}

	public void setRentalIncome(double rentalIncome) {
		this.rentalIncome = rentalIncome;
	}

	public double getPpf() {
		return ppf;
	}

	public void setPpf(double ppf) {
		this.ppf = ppf;
	}

	public double getMedicalInsurance() {
		return medicalInsurance;
	}

	public void setMedicalInsurance(double medicalInsurance) {
		this.medicalInsurance = medicalInsurance;
	}

	public double getEducationLoan() {
		return educationLoan;
	}

	public void setEducationLoan(double educationLoan) {
		this.educationLoan = educationLoan;
	}

	public double getHouseLoan() {
		return houseLoan;
	}

	public void setHouseLoan(double houseLoan) {
		this.houseLoan = houseLoan;
	}

	public double getNps() {
		return nps;
	}

	public void setNps(double nps) {
		this.nps = nps;
	}

	public double getSavingsInterest() {
		return savingsInterest;
	}

	public void setSavingsInterest(double savingsInterest) {
		this.savingsInterest = savingsInterest;
	}

	public double getTds() {
		return tds;
	}

	public void setTds(double tds) {
		this.tds = tds;
	}

	public double getPayableTax() {
		return payableTax;
	}

	public void setPayableTax(double payableTax) {
		this.payableTax = payableTax;
	}

	public String getExtraInfo() {
		return extraInfo;
	}

	public void setExtraInfo(String extraInfo) {
		this.extraInfo = extraInfo;
	}

	public String getVerifiedStatus() {
		return verifiedStatus;
	}

	public void setVerifiedStatus(String verifiedStatus) {
		this.verifiedStatus = verifiedStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Representative getRepresentative_t() {
		return representative_t;
	}

	public void setRepresentative_t(Representative representative_t) {
		this.representative_t = representative_t;
	}

	public Admin getAdmin_t() {
		return admin_t;
	}

	public void setAdmin_t(Admin admin_t) {
		this.admin_t = admin_t;
	}
}
