package com.taxfiling.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.EditProfileService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EditProfileController {

	@Autowired
	private EditProfileService es;

	@PutMapping("/editCustomer/{id},{editChoice},{newValue}")
	@ApiOperation("Choices: 1.Name  2.Email  3.Password  4.Pan Number  5.Contact Number  6.Bank Account Number  7.Marital Status  8.Address")
	public String upadteCustomer(@PathVariable("id") Long id, @PathVariable("editChoice") Integer choice,
			@PathVariable("newValue") String newValue) {
		int i = 0;
		String[] res = new String[2];
		Customer c = es.findCustomer(id);
		switch (choice) {
		case 1:
			c.setName(newValue);
			i = es.updateCustomer(c);
			res[0] = "Name";
			res[1] = c.getName();
			break;
		case 2:
			c.setEmail(newValue);
			i = es.updateCustomer(c);
			res[0] = "Email";
			res[1] = c.getEmail();
			break;
		case 3:
			c.setPassword(newValue);
			i = es.updateCustomer(c);
			res[0] = "Password";
			res[1] = c.getPassword();
			break;
		case 4:
			c.setPan(newValue);
			i = es.updateCustomer(c);
			res[0] = "Pan";
			res[1] = c.getPan();
			break;
		case 5:
			c.setContactNo(newValue);
			i = es.updateCustomer(c);
			res[0] = "Contact Number";
			res[1] = c.getContactNo();
			break;
		case 6:
			c.setAccountNo(newValue);
			i = es.updateCustomer(c);
			res[0] = "Bank Account Number";
			res[1] = c.getAccountNo();
			break;
		case 7:
			c.setMaritalStatus(newValue);
			i = es.updateCustomer(c);
			res[0] = "Marital Status";
			res[1] = c.getMaritalStatus();
			break;
		case 8:
			c.setAddress(newValue);
			i = es.updateCustomer(c);
			res[0] = "Address";
			res[1] = c.getAddress();
			break;
		default:
			return "Wrong choice entered!";
		}

		if (i == 1)
			return "Your " + res[0] + " is now: " + res[1];
		else
			return "An error occured!";
	}

	@PutMapping("/editEmployer/{id},{editChoice},{newValue}")
	@ApiOperation("Choices: 1.Email  2.Password  3.Contact Number")
	public String upadteEmployer(@PathVariable("id") Long id, @PathVariable("editChoice") Integer choice,
			@PathVariable("newValue") String newValue) {

		int i = 0;
		String[] res = new String[2];
		Employer e = es.findEmployer(id);
		switch (choice) {
		case 1:
			e.setEmail(newValue);
			i = es.updateEmployer(e);
			res[0] = "Email";
			res[1] = e.getEmail();
			break;
		case 2:
			e.setPassword(newValue);
			i = es.updateEmployer(e);
			res[0] = "Password";
			res[1] = e.getPassword();
			break;
		case 3:
			e.setContactNo(newValue);
			i = es.updateEmployer(e);
			res[0] = "Contact Number";
			res[1] = e.getContactNo();
			break;
		default:
			return "Wrong choice entered!";
		}

		if (i == 1)
			return "Your " + res[0] + " is now: " + res[1];
		else
			return "An error occured!";
	}

	@PutMapping("/editRepresentative/{id},{editChoice},{newValue}")
	@ApiOperation("Choices: 1.Name  2.Email  3.Password  4.Contact Number")
	public String upadteRepresentative(@PathVariable("id") Long id, @PathVariable("editChoice") Integer choice,
			@PathVariable("newValue") String newValue) {

		int i = 0;
		String[] res = new String[2];
		Representative r = es.findRepresentative(id);
		switch (choice) {
		case 1:
			r.setName(newValue);
			i = es.updateRepresentative(r);
			res[0] = "Name";
			res[1] = r.getName();
			break;
		case 2:
			r.setEmail(newValue);
			i = es.updateRepresentative(r);
			res[0] = "Email";
			res[1] = r.getEmail();
			break;
		case 3:
			r.setPassword(newValue);
			i = es.updateRepresentative(r);
			res[0] = "Password";
			res[1] = r.getPassword();
			break;
		case 4:
			r.setContactNo(newValue);
			i = es.updateRepresentative(r);
			res[0] = "Contact Number";
			res[1] = r.getContactNo();
			break;
		default:
			return "Wrong choice entered!";
		}

		if (i == 1)
			return "Your " + res[0] + " is now: " + res[1];
		else
			return "An error occured!";
	}

	@PutMapping("/editAdmin/{id},{editChoice},{newValue}")
	@ApiOperation("Choices: 1.password")
	public String upadteAdmin(@PathVariable("id") String id, @PathVariable("editChoice") Integer choice,
			@PathVariable("newValue") String newValue) {

		int i = 0;
		String[] res = new String[2];
		Admin a = es.findAdmin(id);
		if (choice == 1) {
			a.setPassword(newValue);
			i = es.updateAdmin(a);
			res[0] = "Password";
			res[1] = a.getPassword();
		} else
			return "Wrong choice entered!";

		if (i == 1)
			return "Your " + res[0] + " is now: " + res[1];
		else
			return "An error occured!";
	}

	@PutMapping("/forgotPassword/{id},{userChoice},{questionChoice},{answer},{newPassword}")
	@ApiOperation("User Choices: 1.Customer 2.Employer 3.Representative   " + "****QuestionChoice****= "
			+ "1.what is your nickname?, 2.what is place of birth?, 3.What is your fathers name?")
	public String forgotPassword(@PathVariable("id") String id, @PathVariable("userChoice") int choice,
			@PathVariable("questionChoice") int questionChoice, @PathVariable("answer") String answer,
			@PathVariable("newPassword") String newPass) {

		List<String> questions = Arrays.asList("1.what is your nickname?", "2.what is place of birth?",
				"3.What is your fathers name?");

		String res = "Sorry!! Question or answer is incorrect";
		switch (choice) {
		case 1:
			Customer c = es.findCustomer(Long.parseLong(id));
			if (c.getSecurityQuestion().equalsIgnoreCase(questions.get(questionChoice - 1))
					&& c.getSecurityAnswer().equals(answer)) {
				c.setPassword(newPass);
				es.updateCustomer(c);
				res = "Password resetted succesfully";
			}
			break;
		case 2:
			Employer e = es.findEmployer(Long.parseLong(id));
			if (e.getSecurityQuestion().equalsIgnoreCase(questions.get(questionChoice - 1))
					&& e.getSecurityAnswer().equals(answer)) {
				e.setPassword(newPass);
				es.updateEmployer(e);
				res = "Password resetted succesfully";
			}
			break;
		case 3:
			Representative r = es.findRepresentative(Long.parseLong(id));
			if (r.getSecurityQuestion().equalsIgnoreCase(questions.get(questionChoice - 1))
					&& r.getSecurityAnswer().equals(answer)) {
				r.setPassword(newPass);
				es.updateRepresentative(r);
				res = "Password resetted succesfully";
			}
			break;
		default:
			return "Wrong choice entered!";
		}

		return res;
	}

	@DeleteMapping("/removeActor/{userChoice}/{id}")
	@ApiOperation("Choices: 1.Customer 2.Employer  3.Representative")
	public String removeActor(@PathVariable("userChoice") int choice, @PathVariable("id") Long id) {
		int i = 0;
		String[] res = new String[2];
		switch (choice) {
		case 1:
			i = es.removeCustomer(id);
			res[0] = "Customer";
			res[1] = Long.toString(id);
			break;
		case 2:
			i = es.removeEmployer(id);
			res[0] = "Employer";
			res[1] = Long.toString(id);
			break;
		case 3:
			i = es.removeRepresentative(id);
			res[0] = "Representative";
			res[1] = Long.toString(id);
			break;
		default:
			return "Wrong choice entered!";
		}
		if (i == 1)
			return res[0] + " with id " + res[1] + " has been deleted succesfully";
		else
			return "An error occured!";
	}
}
