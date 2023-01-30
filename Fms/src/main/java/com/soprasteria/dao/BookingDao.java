package com.soprasteria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.soprasteria.model.Booking;

public interface BookingDao extends JpaRepository<Booking, String> {

}
