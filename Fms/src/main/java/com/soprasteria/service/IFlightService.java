package com.soprasteria.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.soprasteria.model.Flight;

@Service
public interface IFlightService {

  Flight addFlight(Flight flight);

  ResponseEntity<Flight> getFlightBySourceDestination(String source, String destination);

  List<Flight> viewAllFlights();

  ResponseEntity<String> deleteFlightById(Integer id);

  ResponseEntity<String> updateFlightById(Flight flight);

  Flight getFlight(Integer id);

}
