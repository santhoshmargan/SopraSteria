package com.soprasteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.model.Booking;
import com.soprasteria.service.IBookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	private IBookingService service;

	@PostMapping("/saveBooking")
	public ResponseEntity<?> addBooking(@RequestBody Booking bookingRequest) {
		
		return service.addBooking(bookingRequest);
	}
	
	@DeleteMapping("/deleteBooking/{bookingId}")
	public ResponseEntity<?> deleteBookingById(@PathVariable String bookingId) {
	  return service.deleteBookingById(bookingId);
	}
	
	@PutMapping("/modifyBooking")
	public ResponseEntity<?> modifyBooking(@RequestBody Booking bookingRequest) {
		
		return service.modifyBooking(bookingRequest);
	}
	
	@GetMapping("/readAllBooking")
	public ResponseEntity<List<Booking>> readAllBooking() {
		
		return service.readAllBooking();
	}
	
	@PostMapping("/getBookingById/{bookingId}")
	public ResponseEntity<Booking> searchBookingById(@PathVariable String bookingId) {
		return service.searchBookingById(bookingId);
	}
}
