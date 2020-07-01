package com.project1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.project1.model.Bookings;

public interface BookingsService {

	public List<Bookings> getAllBookings();
	public Optional<Bookings> getBookingsById(int id);
	public Bookings addBookings(Bookings add);
	public ResponseEntity<Bookings> updateBookings(Integer id, Bookings newUpdateBookings);
	public boolean deleteBookings(int id);
}
