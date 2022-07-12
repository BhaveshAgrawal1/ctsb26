package com.demo.api;

//@Component
public class EnglishConverter implements MessageConverter {

	@Override
	public void translate(String msg) {
		System.out.println("English: "+msg);
	}
	
}
