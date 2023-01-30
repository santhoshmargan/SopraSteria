package com.soprasteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.soprasteria.dao.FlightBookingDao;
import com.soprasteria.exceptions.RecordAlreadyExistsException;
import com.soprasteria.exceptions.RecordNotFoundException;
import com.soprasteria.model.Flight;

@Service
public class FlightServiceImpl implements IFlightService {

  @Autowired
  private FlightBookingDao flightBookingDao;

  @Override
  public Flight addFlight(Flight flight) {
    flightBookingDao.save(flight);
    return flight;
  }

  public ResponseEntity<Flight> getFlightBySourceDestination(String source, String destination) {
    List<Flight> flights = flightBookingDao.findAll();
    Flight response = new Flight();
    for (Flight temp : flights) {
      if (temp.getSource().equalsIgnoreCase(source)
          && temp.getDestination().equalsIgnoreCase(destination)) {
        response = temp;
      }
    }
    return new ResponseEntity<Flight>(response, HttpStatus.OK);
  }

  @Override
  public List<Flight> viewAllFlights() {

    return flightBookingDao.findAll();
  }

  @Override
  public ResponseEntity<String> deleteFlightById(Integer id) {
    Optional<Flight> findResponse = flightBookingDao.findById(id);
    if (findResponse.isPresent()) {
      flightBookingDao.deleteById(id);
      return new ResponseEntity<String>("Flight with id: " + id + "deleted successfully!!",
          HttpStatus.OK);
    } else {
      throw new RecordNotFoundException(id.toString());
    }
  }

  @Override
  public ResponseEntity<String> updateFlightById(Flight flight) {
    Optional<Flight> findResponse = flightBookingDao.findById(flight.getId());
    if (findResponse.isPresent()) {
      flightBookingDao.save(flight);
      return new ResponseEntity<String>(
          "Flight with id: " + flight.getId() + "updated successfully", HttpStatus.OK);
    } else {
      throw new RecordAlreadyExistsException(flight.getId().toString());
    }
  }

  @Override
  public Flight getFlight(Integer id) {
    Optional<Flight> flight = flightBookingDao.findById(id);
    if (flight.isPresent()) {
      return flight.get();
    }
    return null;
  }

}
