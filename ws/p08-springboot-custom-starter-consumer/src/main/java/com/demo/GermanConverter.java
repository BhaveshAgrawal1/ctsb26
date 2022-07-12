package com.demo;

import org.springframework.stereotype.Component;

import com.demo.api.MessageConverter;

@Component
public class GermanConverter implements MessageConverter {

	@Override
	public void translate(String msg) {
		System.out.println("German: "+msg);
	}

}
