package com.project1.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.project1.model.Bookings;
import com.project1.repository.BookingsRepository;
import com.project1.service.BookingsService;

@Service
public class BookingsServiceImpl implements BookingsService{

	@Autowired
	BookingsRepository bookingsRepository;

	@Override
	public List<Bookings> getAllBookings() {
		// TODO Auto-generated method stub
		return bookingsRepository.findAll();
	}

	@Override
	public Optional<Bookings> getBookingsById(int id) {
		// TODO Auto-generated method stub
		return bookingsRepository.findById(id);
	}

	@Override
	public Bookings addBookings(Bookings add) {
		// TODO Auto-generated method stub
		Bookings users=bookingsRepository.save(new Bookings(
//				add.getBookingId(),
				add.getBookingFrom(),
				add.getBookingTo(),
				add.getStatus(),
				add.getDaysWorked(),
				add.getUserId(),
				add.getEmployeeId())
				);
		return users;
	}



	@Override
	public ResponseEntity<Bookings> updateBookings(Integer id, Bookings newUpdateBookings) {
		// TODO Auto-generated method stub
		Optional<Bookings> existningBookings = bookingsRepository.findById(id);

		if (existningBookings.isPresent()) {
			Bookings tempBooking = existningBookings.get();
			tempBooking.setBookingFrom(newUpdateBookings.getBookingFrom());
			tempBooking.setBookingTo(newUpdateBookings.getBookingTo());
			tempBooking.setDaysWorked(newUpdateBookings.getDaysWorked());
			tempBooking.setEmployeeId(newUpdateBookings.getEmployeeId());
			tempBooking.setStatus(newUpdateBookings.getStatus());
			tempBooking.setUserId(newUpdateBookings.getUserId());

			return new ResponseEntity<>(bookingsRepository.save(tempBooking), HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	@Override
	public boolean deleteBookings(int id) {
		// TODO Auto-generated method stub
		bookingsRepository.deleteById(id);
		return false;
	}
}
