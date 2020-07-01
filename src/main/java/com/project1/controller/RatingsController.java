package com.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.model.Ratings;
import com.project1.service.RatingsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RatingsController {

	@Autowired
	RatingsService ratingsService;

	//1. GET ALL RATINGS
	@GetMapping("/getallratings")
	public ResponseEntity<List<Ratings>> getAllratings() {
		try {
			List<Ratings> ratings = ratingsService.getAllRatings();
//				System.out.println(ratings.isEmpty());
			
			if (ratings.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(ratings, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//2. GET RATINGS BY ID
	@GetMapping("/ratings/{id}")
	public ResponseEntity<Ratings> getratingsById(@PathVariable("id") Integer id) {
		Optional<Ratings> ratings = ratingsService.getRatingsById(id);

		if (ratings.isPresent()) {
			return new ResponseEntity<>(ratings.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//3. ADD RATINGS
	@PostMapping("/addratings")
	public ResponseEntity<Ratings> createTutorial(@RequestBody Ratings add) {
		
		try {
			
			Ratings ratings = ratingsService.addRatings(add);
			return new ResponseEntity<>(ratings, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
}
