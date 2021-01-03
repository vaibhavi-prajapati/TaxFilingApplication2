package com.taxfiling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.taxfiling.service.LoginService;

import io.swagger.annotations.ApiOperation;

@RestController
public class LoginController {
	@Autowired
	private LoginService ls;

	@GetMapping("/login/{id},{password},{choice}")
	@ApiOperation("choices: 1.Customer 2.Employer 3.Representative")
	public String login(@PathVariable("id") String id, @PathVariable("password") String password,
			@PathVariable("choice") Integer choice) {
		Object obj = null;
		switch (choice) {
		case 1:
			obj = ls.loginCustomer(Long.parseLong(id), password);
			break;
		case 2:
			obj = ls.loginEmployer(Long.parseLong(id), password);
			break;
		case 3:
			obj = ls.loginRepresentative(Long.parseLong(id), password);
			break;
		case 4:
			obj = ls.loginAdmin(id, password);
			break;
		default:
			return "Wrong choice entered!";
		}
		if (obj != null)
			return "Login successfull";
		else
			return "Id or password is incorrect";
	}
}
