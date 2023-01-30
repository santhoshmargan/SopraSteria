package com.soprasteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soprasteria.model.Airport;

public interface AirportDao  extends JpaRepository<Airport, Integer> {

}
