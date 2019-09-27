package com.example.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class UserController {

//	//@Autowired
//	private AppUserRepository service;
//	public UserController( AppUserRepository service) {
//		this.service=service;
//	}
//	
	@RequestMapping("/home")
	public String Home() {
		return "hello, I'm Auth's home";
	}
	
}
