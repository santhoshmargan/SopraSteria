package com.soprasteria.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.soprasteria.model.Airport;
import com.soprasteria.service.IAirportService;

@RestController
@RequestMapping("/airports")
public class AirportController {

  @Autowired
  private IAirportService airportService;


  // Airport Components

  @PostMapping("/saveAirport")
  public ResponseEntity<String> saveAirport(@RequestBody Airport airport) {
    airportService.addAirport(airport);
    return new ResponseEntity<String>("Data posted successfully to database...", HttpStatus.OK);
  }
  
  @GetMapping("/destinations/{source}")
  public ResponseEntity<List<Airport>> getDestinationAirports(@PathVariable String source) {

    List<Airport> findResponse = airportService.viewAllAirport();
    List<Airport> response = new ArrayList<>();
    /*
     * String destinationCities[] = new String[findResponse.size()]; for (Airport airport :
     * findResponse) { if (airport.getCityName() != null &&
     * !airport.getCityName().equalsIgnoreCase(source)) { for (int i = 0; i < findResponse.size();
     * i++) { destinationCities[i] = airport.getCityName(); } } }
     */
    if (findResponse.size() > 0) {
      for (Airport temp : findResponse) {
        if (!temp.getCityName().equalsIgnoreCase(source)) {
          response.add(temp);
        }
      }
      return new ResponseEntity<List<Airport>>(response, HttpStatus.OK);
    }

    return new ResponseEntity<List<Airport>>(response, HttpStatus.NO_CONTENT);
  }

  @GetMapping("/allAirports")
  public ResponseEntity<List<Airport>> getAllAirports() {
    List<Airport> findResponse = airportService.viewAllAirport();

    if (findResponse.size() > 0) {
      return new ResponseEntity<List<Airport>>(findResponse, HttpStatus.OK);
    }

    return new ResponseEntity<List<Airport>>(findResponse, HttpStatus.NO_CONTENT);
  }

  
  @PutMapping("/updateAirport")
  public ResponseEntity<String> modifyAirport(@RequestBody Airport airport) {

    return airportService.modifyAirport(airport);

  }


  @GetMapping("/getAirportById/{id}")
  public ResponseEntity<Airport> viewAirport(@PathVariable Integer id) {

    return airportService.viewAirport(id);
  }

  @DeleteMapping("/deleteAirport/{id}")
  public ResponseEntity<String> removeAirport(@PathVariable Integer id) {
    return airportService.removeAirport(id);
  }

}
