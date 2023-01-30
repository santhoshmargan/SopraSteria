package com.soprasteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.soprasteria.dao.BookingDao;
import com.soprasteria.exceptions.RecordAlreadyExistsException;
import com.soprasteria.exceptions.RecordNotFoundException;
import com.soprasteria.model.Booking;

@Service
public class BookingServiceImpl implements IBookingService{

	@Autowired
	private BookingDao bookingDao;
	
	@Override
	public ResponseEntity<Booking> addBooking(Booking bookingRequest) {

		Optional<Booking> findResponse = bookingDao.findById(bookingRequest.getBookingId());
		if (!findResponse.isPresent()) {
			bookingDao.save(bookingRequest);
			return new ResponseEntity<Booking>(bookingRequest, HttpStatus.OK);
		} else {
			throw new RecordAlreadyExistsException(
					"Booking Id: " + bookingRequest.getBookingId() + " already present!!");
		}

	}

	@Override
	public ResponseEntity<String> deleteBookingById(String id) {
		Optional<Booking> findResponse = bookingDao.findById(id);
		if (findResponse.isPresent()) {
			bookingDao.deleteById(id);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		} else {
			throw new RecordNotFoundException(
					"Booking Id: " + id + " is not present!!");
		}
	}

	@Override
    public ResponseEntity<?> modifyBooking(Booking bookingRequest) {
      Optional<Booking> searchResponse = bookingDao.findById(bookingRequest.getBookingId());
      Booking response = new Booking();
      if (searchResponse.isPresent()) {
        response = searchResponse.get();
        if (bookingRequest.getNoOfPassengers() != null) {
          response.setNoOfPassengers(bookingRequest.getNoOfPassengers());
        }
        if (bookingRequest.getBookingDate() != null) {
          response.setBookingDate(bookingRequest.getBookingDate());
        }
        bookingDao.save(response);
        return new ResponseEntity<String>(
            "Booking with Id: " + bookingRequest.getBookingId() + " updated successfully!",
            HttpStatus.OK);
      } else {
        throw new RecordNotFoundException(
            "Booking Id: " + bookingRequest.getBookingId() + " is not present!!");
      }


    }

	@Override
	public ResponseEntity<List<Booking>> readAllBooking() {

		List<Booking> searchResponse = bookingDao.findAll();
		return new ResponseEntity<List<Booking>>(searchResponse, HttpStatus.OK);

	}

	@Override
	public ResponseEntity<Booking> searchBookingById(String bookingId) {
		Optional<Booking> findResponse = bookingDao.findById(bookingId);
		if (findResponse.isPresent()) {
			Booking response = findResponse.get();
			return new ResponseEntity<Booking>(response, HttpStatus.OK);
		} else {
			throw new RecordNotFoundException(
					"Booking Id: " + bookingId + " is not present!!");
		}
	}

}
