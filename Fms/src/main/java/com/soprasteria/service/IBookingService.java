package com.soprasteria.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.soprasteria.model.Booking;

@Service
public interface IBookingService {

	public ResponseEntity<Booking> addBooking(@RequestBody Booking bookingRequest);

	public ResponseEntity<String> deleteBookingById(String id);

	public ResponseEntity<?> modifyBooking(Booking bookingRequest);

	public ResponseEntity<List<Booking>> readAllBooking();

	public ResponseEntity<Booking> searchBookingById(@PathVariable String bookingId);
}
