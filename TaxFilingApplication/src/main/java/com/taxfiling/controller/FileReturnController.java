package com.taxfiling.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Notice;
import com.taxfiling.entity.Representative;
import com.taxfiling.entity.TaxForm;
import com.taxfiling.service.FileReturnService;

import io.swagger.annotations.ApiOperation;

@RestController
public class FileReturnController {
	@Autowired
	private FileReturnService fileReturnService;

	@PostMapping("/fileReturn/{customerId}")
	@ApiOperation("Enter the customer Id who is filing returns")
	public String fileReturn(@PathVariable("customerId") Long id) {
		String str = "";
		Customer c = fileReturnService.getCustomerById(id);
		if (c.getTaxForm() != null) {
			TaxForm t = fileReturnService.getTaxFromByPan(c.getPan());
			if (t.getVerifiedStatus().equals("pending")) {
				str = "Your taxForm is yet to be verified by representative. Check after some time.";
			} else if (t.getVerifiedStatus().equals("verified")) {
				int i = fileReturnService.fileReturn(t);
				if (i > 0)
					str = "File has been successfuly returned. Wait till admin approves the same.";
				else
					str = "An error occurred!";
			} else if (t.getVerifiedStatus().equals("approved")) {
				str = "Your file return is already approved.";
			} else if (t.getVerifiedStatus().equals("none")) {
				str = "Add tax details first!";
			} else if (t.getVerifiedStatus().equals("approvePending")) {
				str = "Your file return is yet to be approved by admin.";
			} else if (t.getVerifiedStatus().equals("rejected_r")) {
				str = "Your file return is rejected by representative.";
			} else if (t.getVerifiedStatus().equals("rejected_a")) {
				str = "Your file return is rejected by admin.";
			}
		} else {
			str = "Add tax details first!";
		}
		return str;
	}

	@GetMapping("/getTaxFormsForRepresentative")
	public List<TaxForm> getTaxFormsForRepresentative() {
		return fileReturnService.getTaxFormsForRepresentative();
	}

	@GetMapping("/getTaxFormsForAdmin")
	public List<TaxForm> getTaxFormsForAdmin() {
		return fileReturnService.getTaxFormsForAdmin();
	}

	@PutMapping("/verifyTaxformByRepresentative/{representativeID}/{taxformId}/{choice}")
	@ApiOperation("For choice, enter 1. To approve   2. To reject")
	public String verifyTaxFormsByRepresentative(@PathVariable("representativeID") Long representativeID,
			@PathVariable("taxformId") Long taxformId, @PathVariable("choice") int choice) {
		String str = "";
		Representative r = fileReturnService.getRepresentativeById(representativeID);
		Customer c = fileReturnService.getCustomerByTaxFormId(taxformId);
		if (choice == 1) {
			Notice n = new Notice();
			TaxForm tf = fileReturnService.getTaxFromByPan(c.getPan());
			double tax = tf.getPayableTax() - tf.getTds();
			if (tax > 0)
				n.setNoticeBody("Your Application is verified. Total tax to be paid is " + tax);
			else if (tax < 0)
				n.setNoticeBody("Your Application is verified. You are eligible for a refund of Rs." + (tax * (-1)));
			else
				n.setNoticeBody("Your Application is verified. You dont have to pay tax");
			n.setCustomer(c);
			n.setRepresentative_n(r);
			int i = fileReturnService.addNotice(n);
			if (i == 1) {
				str = "Verified notice is sent to customer.";
				fileReturnService.updateTaxForm(taxformId, "verified");
			} else
				str = "An error occured!";
		} else if (choice == 2) {
			Notice n = new Notice();
			n.setNoticeBody("Your Details are Incorrect .Your Application is Rejected.");
			n.setCustomer(c);
			n.setRepresentative_n(r);
			int i = fileReturnService.addNotice(n);
			if (i > 0) {
				str = "Rejection notice is sent to customer.";
				fileReturnService.updateTaxForm(taxformId, "rejected_r");
			} else
				str = "An error occured!";
		} else {
			str = "Wrong choice. Try again!";
		}
		return str;
	}

	@PutMapping("/verifyTaxformByAdmin/{taxformId}/{choice}")
	@ApiOperation("For choice, enter 1. To approve   2. To reject")
	public String verifyTaxFormsByAdmin(@PathVariable("taxformId") Long taxformId, @PathVariable("choice") int choice) {
		String str = "";
		Admin a = fileReturnService.getAdmin();
		Customer c = fileReturnService.getCustomerByTaxFormId(taxformId);
		if (choice == 1) {
			Notice n = new Notice();
			n.setNoticeBody("Your Application is Approved.");
			n.setCustomer(c);
			n.setAdmin_n(a);
			int i = fileReturnService.addNotice(n);
			if (i > 0) {
				str = "Approval notice is sent to customer.";
				fileReturnService.updateTaxForm(taxformId, "approved");
			} else
				str = "An error occured!";
		} else if (choice == 2) {
			Notice n = new Notice();
			n.setNoticeBody("Your Application is Rejected.");
			n.setCustomer(c);
			n.setAdmin_n(a);
			int i = fileReturnService.addNotice(n);
			if (i > 0) {
				str = "Rejection notice is sent to customer.";
				fileReturnService.updateTaxForm(taxformId, "rejected_a");
			} else
				str = "An error occured!";
		} else {
			str = "Wrong choice. Try again!";
		}
		return str;
	}
}
