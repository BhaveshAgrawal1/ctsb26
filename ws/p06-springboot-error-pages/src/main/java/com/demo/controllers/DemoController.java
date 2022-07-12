package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@RestController = @Controller + @ResponseBody
@Controller
public class DemoController {

	@GetMapping("/greet")
	public String greetUser() {
		System.out.println("greet found");
		return "welcome";
	}
	
	@GetMapping("/greet/{name}")
	@ResponseBody
	public String greetUser(@PathVariable String name) {
		name = (""+name.charAt(0)).toUpperCase() + name.substring(1).toLowerCase();
		return "welcome "+name;
	}
	
	@GetMapping("/div/{a}/{b}")
	@ResponseBody
	public String divide(@PathVariable int a, @PathVariable int b) {
		return ""+(a/b);
	}

	@PostMapping("/store/{a}/{b}")
	public String saveInFile(@PathVariable int a, @PathVariable int b) {
		return "saved";
	}

	
}
