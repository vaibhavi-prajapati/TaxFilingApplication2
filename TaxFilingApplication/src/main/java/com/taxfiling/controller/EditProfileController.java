package com.taxfiling.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.entity.Admin;
import com.taxfiling.entity.Customer;
import com.taxfiling.entity.Employer;
import com.taxfiling.entity.Representative;
import com.taxfiling.service.EditProfileService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EditProfileController {

	Logger logger = LoggerFactory.getLogger(EditProfileController.class);

	@Autowired
	private EditProfileService es;

	@PutMapping("updateCustomer/{id}")
	public Customer updateCustomer(@RequestBody Customer customer, @PathVariable("id") long id) {
		Customer c = es.findCustomer(id);
		c.setName(customer.getName());
		c.setEmail(customer.getEmail());
		c.setPassword(customer.getPassword());
		c.setContactNo(customer.getContactNo());
		c.setAccountNo(customer.getAccountNo());
		c.setMaritalStatus(customer.getMaritalStatus());
		c.setAddress(customer.getAddress());

		return es.updateCustomer(c);
	}

	@PutMapping("updateEmployer/{id}")
	public Employer updateEmployer(@RequestBody Employer employer, @PathVariable("id") long id) {
		Employer emp = es.findEmployer(id);
		emp.setEmail(employer.getEmail());
		emp.setPassword(employer.getPassword());
		emp.setContactNo(employer.getContactNo());

		return es.updateEmployer(emp);
	}

	@PutMapping("updateRepresentative/{id}")
	public Representative updateRepresentative(@RequestBody Representative representative,
			@PathVariable("id") long id) {
		Representative rep = es.findRepresentative(id);
		rep.setName(representative.getName());
		rep.setEmail(representative.getEmail());
		rep.setPassword(representative.getPassword());
		rep.setContactNo(representative.getContactNo());

		return es.updateRepresentative(rep);
	}

	@PutMapping("updateAdmin/{id}")
	public Admin updateAdmin(@RequestBody Admin admin, @PathVariable("id") String id) {
		Admin a = es.findAdmin(id);
		a.setPassword(admin.getPassword());

		return es.updateAdmin(a);
	}

	@PutMapping("/forgotPassword/{id}/{userChoice}/{questionChoice}/{answer}/{newPassword}")
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
