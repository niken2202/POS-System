package com.example.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.UserService;

@RestController
@RequestMapping("/service/customer_account")
public class UserController {

	@Autowired
	private UserService service;
	public UserController( UserService service) {
		this.service=service;
	}
	
	@RequestMapping("/home")
	public String Home() {
		return "hello";
	}
	
}
