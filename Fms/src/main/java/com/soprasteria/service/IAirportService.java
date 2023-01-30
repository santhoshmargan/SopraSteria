package com.soprasteria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.soprasteria.model.Airport;

@Service
public interface IAirportService {

  ResponseEntity<?> addAirport(Airport airport);

  List<Airport> viewAllAirport();

  ResponseEntity<String> modifyAirport(Airport airport);

  ResponseEntity<Airport> viewAirport(Integer airportId);

  ResponseEntity<String> removeAirport(Integer airportId);


}
