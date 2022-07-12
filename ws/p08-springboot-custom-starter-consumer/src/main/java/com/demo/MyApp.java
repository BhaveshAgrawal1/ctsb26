package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.api.MessageConverter;

@SpringBootApplication
public class MyApp implements CommandLineRunner {

	@Autowired
	private MessageConverter converter;
	@Autowired
	private GermanConverter gConverter;
	
	@Override
	public void run(String... args) throws Exception {
		converter.translate("This is dummy message 1");
		gConverter.translate("This is dummy message 2");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
	
}
