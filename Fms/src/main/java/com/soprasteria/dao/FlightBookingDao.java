package com.soprasteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.soprasteria.model.Flight;

@Repository
public interface FlightBookingDao extends JpaRepository<Flight, Integer>{

}
