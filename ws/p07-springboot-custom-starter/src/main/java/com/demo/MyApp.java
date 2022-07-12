package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyApp {//implements CommandLineRunner {

//	@Autowired
//	private MessageConverter converter;
//	
//	@Override
//	public void run(String... args) throws Exception {
//		converter.translate("This is dummy message");
//	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
	
}
