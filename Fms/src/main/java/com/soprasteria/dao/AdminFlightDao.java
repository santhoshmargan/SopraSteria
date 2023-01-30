package com.soprasteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soprasteria.model.Flight;

public interface AdminFlightDao extends JpaRepository<Flight, String>{

}
