package com.project1.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project1.model.Bookings;
import com.project1.service.BookingsService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class BookingsController {

	@Autowired
	BookingsService bookingsService;

	
	//1. GET ALL BOOKING
	
	@GetMapping("/getallbookings")
	public ResponseEntity<List<Bookings>> getAllbookings() {
		try {
			List<Bookings> bookings = bookingsService.getAllBookings();
//				System.out.println(bookings.isEmpty());
			
			if (bookings.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(bookings, HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//2. GET BOOKINGS BY ID
	@GetMapping("/bookings/{id}")
	public ResponseEntity<Bookings> getbookingsById(@PathVariable("id") Integer id) {
		Optional<Bookings> bookings = bookingsService.getBookingsById(id);

		if (bookings.isPresent()) {
			return new ResponseEntity<>(bookings.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	//3. ADD NEW BOOKINGS
	@PostMapping("/addbookings")
	public ResponseEntity<Bookings> createTutorial(@RequestBody Bookings add) {
		try {
			Bookings bookings = bookingsService.addBookings(add);
					
			return new ResponseEntity<>(bookings, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
	
	//4. UPDATE BOOKINGS BY ID
	
	@PutMapping("/updatebookings/{id}")
	public ResponseEntity<Bookings> updateBookings(@PathVariable("id") Integer id, @RequestBody Bookings updateBookings) {
		
		return bookingsService.updateBookings(id, updateBookings);
		
	}
	

	
	//5. DELETE BOOKINGS BY ID
	
	@DeleteMapping("/deletebooking/{id}")
	private ResponseEntity<HttpStatus> deleteBooking(@PathVariable("id") int id) {
		try {
			bookingsService.deleteBookings(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
}
