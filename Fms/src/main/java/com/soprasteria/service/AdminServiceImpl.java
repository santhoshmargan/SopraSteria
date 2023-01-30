package com.soprasteria.service;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl {
  /*
   * 
   * @Autowired private AdminFlightDao adminFlightDao;
   * 
   * @Override public ResponseEntity<?> addFlight(Flight flight) { Optional<Flight> findResponse =
   * adminFlightDao.findById(flight.getFlightNo()); if (!findResponse.isPresent()) {
   * flight.setResult("Success"); adminFlightDao.save(flight); return new
   * ResponseEntity<Flight>(flight, HttpStatus.OK); } else { throw new RecordAlreadyExistsException(
   * "Flight with id: " + flight.getFlightNo() + " is already exists!!"); } }
   * 
   * @Override public ResponseEntity<List<Flight>> viewAllFlights() { return new
   * ResponseEntity<List<Flight>>(adminFlightDao.findAll(), HttpStatus.OK); }
   * 
   * @Override public ResponseEntity<?> updateFlight(Flight flight) {
   * 
   * Optional<Flight> findResponse = adminFlightDao.findById(flight.getNumber()); Flight saveObject
   * = new Flight(); if (findResponse.isPresent()) { saveObject.setResult("Success");
   * adminFlightDao.save(flight); return new ResponseEntity<String>( "Flight with id: " +
   * flight.getNumber() + " updated successfully!", HttpStatus.OK); } else { throw new
   * RecordNotFoundException( "Flight with id: " + flight.getNumber() + " is not exists!!"); } }
   * 
   * @Override public Optional<Flight> getFlightById(String id) {
   * 
   * return adminFlightDao.findById(id); }
   * 
   */}
