package com.demo.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.entities.Book;
import com.demo.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository repo;
	
	public BookService() {
		System.out.println("BookService init");
	}

	public List<Book> fetchAllBooks(){
		return repo.findAll();
	}

	@Cacheable(value="library", key="#id")
	public Book getBookById(int id) {
		System.out.println("find book by id("+id+"): "+LocalDateTime.now());
		Optional<Book> optional = repo.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		} else {		
			System.out.println("Could not find book with id "+id);
			return null; // throw ex
		}
	}
	public Book createBook(Book b) {
		return repo.save(b);
	}
	
	@CachePut(value="library", key="#id")
	public Book updateBook(int id, Book b) {
		System.out.println("update book by id("+id+"): "+LocalDateTime.now());
		Book dbBook = getBookById(id);
		if(dbBook==null) {
			System.out.println("Book with id "+id+" not found");
			return null;
		} else {
			if(b.getAuthor().length()>0) {				
				dbBook.setAuthor(b.getAuthor());
			}
			if(b.getPrice()>0) {
				dbBook.setPrice(b.getPrice());				
			}
			if(b.getTitle().length()>0) {
				dbBook.setTitle(b.getTitle());				
			}
			return repo.save(dbBook);
		}
	}
	
	@CacheEvict(value="library", key="#id")
	public Book deleteBook(int id) {
		System.out.println("delete book by id("+id+"): "+LocalDateTime.now());
		Book dbBook = getBookById(id);
		if(dbBook!=null) {
			repo.delete(dbBook);
		}
		return dbBook;
	}
	
	
	
	
	
}
