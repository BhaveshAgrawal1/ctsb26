package com.demo.exceptions.handlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.demo.exceptions.BookException;
import com.demo.models.ExMessage;

@ControllerAdvice
public class BookExceptionControllerAdvise {
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<?> myExceptionHander(Exception e) {
		System.out.println(e.getMessage());
		e.printStackTrace();
		return new ResponseEntity<ExMessage>(new ExMessage(e.getMessage(), e.getClass()), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
