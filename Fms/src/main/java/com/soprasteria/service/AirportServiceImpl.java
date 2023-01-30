package com.soprasteria.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.soprasteria.dao.AirportDao;
import com.soprasteria.exceptions.RecordNotFoundException;
import com.soprasteria.model.Airport;
import com.soprasteria.utils.ApplicationUtils;

@Service
public class AirportServiceImpl implements IAirportService {

  @Autowired
  private AirportDao repository;

  @Override
  public ResponseEntity<?> addAirport(Airport airport) {
      String code = ApplicationUtils.getAlphaNumericString(6);
      airport.setCode(airport.getCityName());
      repository.save(airport);
      return new ResponseEntity<String>(
          "Aiport with id: " + airport.getId()+ " added successfully!", HttpStatus.OK);

  }

  @Override
  public List<Airport> viewAllAirport() {

    return repository.findAll();
  }

  
  @Override
  public ResponseEntity<String> modifyAirport(Airport airport) {
    Optional<Airport> findResponse = repository.findById(airport.getId());
    if (findResponse.isPresent()) {
      airport.setCode(findResponse.get().getCityName());
      repository.save(airport);
      return new ResponseEntity<String>(
          "Airport with id: " + airport.getId() + " updated successfully", HttpStatus.OK);
    } else {
      throw new RecordNotFoundException(airport.getCode());
    }

  }

  @Override
  public ResponseEntity<Airport> viewAirport(Integer id) {
    Optional<Airport> findResponse = repository.findById(id);
    if (findResponse.isPresent()) {
      return  new ResponseEntity<Airport>(findResponse.get(),HttpStatus.OK);
    }
    return null;
    
  }

  @Override
  public ResponseEntity<String> removeAirport(Integer airportId) {
    repository.deleteById(airportId);
    return new ResponseEntity<String>("Airport deleted successfully", HttpStatus.OK);
  }

}
