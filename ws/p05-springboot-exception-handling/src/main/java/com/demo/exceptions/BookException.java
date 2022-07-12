package com.demo.exceptions;

public class BookException extends Exception {

	public BookException() {
		super();
	}
	
	public BookException(String m) {
		super(m);
	}
	
	public BookException(Exception e) {
		super(e);
	}
	
	public BookException(String m, Exception e) {
		super(m, e);
	}
	
	

}
