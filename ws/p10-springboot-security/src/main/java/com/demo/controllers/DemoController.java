package com.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

	// spring-security => username: user, password: check in console
	
	@GetMapping("/greet")
	public String greetUser() {
		return "Welcome user";
	}
	
	@GetMapping("/greet/{name}")
	public String greetUser(@PathVariable String name) {
		return "Welcome "+name;
	}
	
	// only for admin
	@GetMapping("/admin")
	public String forAdmin() {
		return "Welcome admin";
	}

	// only for user
	@GetMapping("/user")
	public String forUser() {
		return "Welcome user";
	}
	
}
