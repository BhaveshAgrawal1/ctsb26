package com.demo.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.clients.SuperheroMoviesClient;
import com.demo.model.Show;

@RestController
@RequestMapping("/shows")
public class ShowController {
	
	@Autowired
	private SuperheroMoviesClient client;

	@GetMapping("/demo")
	public List<Show> getShows(){
		return Arrays.asList(
				new Show("Show 1", "Me", 5.0),
				new Show("Show 2", "You", 4.9),
				new Show("Show 3", "He", 4.7),
				new Show("Show 4", "She", 4.7)
		);
	}
	
	@GetMapping("/movies")
	public List<Show> getMovies(){
		return client.getMovies();
	}

	
}
