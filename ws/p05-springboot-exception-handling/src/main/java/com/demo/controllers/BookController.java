package com.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entities.Book;
import com.demo.exceptions.BookException;
import com.demo.models.ExMessage;
import com.demo.services.BookService;

@RestController
//@CrossOrigin(origins = {"http://localhost:4200", "https://hoppscotch.io/"})
@CrossOrigin
public class BookController {

	@Autowired
	private BookService service;
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return service.fetchAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBook(@PathVariable int id) throws BookException {
		return service.getBookById(id);
	}
	
	@PostMapping("/books")
	public Book saveBook(@RequestBody Book book) {
		return service.createBook(book);
	}
	
//	@ExceptionHandler(RuntimeException.class)
//	public ExMessage myExceptionHander(Exception e) {
//		System.out.println(e.getMessage());
//		e.printStackTrace();
//		return new ExMessage(e.getMessage(), e.getClass());
//	}
	
//	@ExceptionHandler(BookException.class)
//	public ResponseEntity<?> myExceptionHander(Exception e) {
//		System.out.println(e.getMessage());
//		e.printStackTrace();
//		return new ResponseEntity<ExMessage>(new ExMessage(e.getMessage(), e.getClass()), HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
