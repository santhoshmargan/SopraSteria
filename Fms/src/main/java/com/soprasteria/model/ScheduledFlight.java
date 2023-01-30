package com.soprasteria.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScheduledFlight {
	
	@Id
	private String scheduleFlightId;
	private Integer availableSeats;
	private String flight;
	private Boolean prime;
	private String result;
	private String schedule; 
	private String other;
	public Integer getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public Boolean getPrime() {
		return prime;
	}
	public void setPrime(Boolean prime) {
		this.prime = prime;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getSchedule() {
		return schedule;
	}
	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}
	public String getScheduleFlightId() {
		return scheduleFlightId;
	}
	public void setScheduleFlightId(String scheduleFlightId) {
		this.scheduleFlightId = scheduleFlightId;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	
	

}
