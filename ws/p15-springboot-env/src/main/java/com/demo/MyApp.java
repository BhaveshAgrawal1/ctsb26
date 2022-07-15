package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MyApp implements CommandLineRunner {

	@Autowired
	private Environment env;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("App started...");
		System.out.println("JAVA_HOME: "+env.getProperty("JAVA_HOME"));
		System.out.println("ABC: "+env.getProperty("ABC"));
		System.out.println("DEMO: "+env.getProperty("DEMO"));
	}

	public static void main(String[] args) {
		SpringApplication.run(MyApp.class, args);
	}
	
}
