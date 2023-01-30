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
import com.soprasteria.model.Flight;
import com.soprasteria.service.IFlightService;

@RestController
@RequestMapping(value="/flights")
public class FlightController {

  @Autowired
  private IFlightService service;

  @PostMapping("/addFlight")
  public Flight addFlight(@RequestBody Flight flight) {
    Flight response = service.addFlight(flight);
    return response;
  }

  @GetMapping("/{source}/{destination}")
  public ResponseEntity<Flight> getFlightBySourceDestination(@PathVariable String source,
      @PathVariable String destination) {
    ResponseEntity<Flight> response = service.getFlightBySourceDestination(source, destination);
    return response;
  }

  @GetMapping("/getFlight/{id}")
  public Flight getFlight(@PathVariable Integer id) {
    return service.getFlight(id);
  }

  @GetMapping("/viewAllFlight")
  public List<Flight> viewAllFlight() {
    return service.viewAllFlights();
  }

  @DeleteMapping("/deleteById/{id}")
  public ResponseEntity<String> deleteFlightById(@PathVariable Integer id) {
    ResponseEntity<String> response = service.deleteFlightById(id);
    return response;
  }

  @PutMapping("/updateFlight")
  public ResponseEntity<String> updateFlightById(@RequestBody Flight flight) {
    ResponseEntity<String> response = service.updateFlightById(flight);
    return response;
  }


}
