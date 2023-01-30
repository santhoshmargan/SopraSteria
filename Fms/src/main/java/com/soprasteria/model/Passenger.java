package com.soprasteria.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Passenger {
	
	@Id
	private String pnrNumber;
	private String luggage;
	private Integer passengerAge;
	private String passengerName;
	private String passengerUin;
	
	public String getLuggage() {
		return luggage;
	}
	public void setLuggage(String luggage) {
		this.luggage = luggage;
	}
	public Integer getPassengerAge() {
		return passengerAge;
	}
	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}
	public String getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}
	public String getPassengerUin() {
		return passengerUin;
	}
	public void setPassengerUin(String passengerUin) {
		this.passengerUin = passengerUin;
	}
	public String getPnrNumber() {
		return pnrNumber;
	}
	public void setPnrNumber(String pnrNumber) {
		this.pnrNumber = pnrNumber;
	}
	
	
	

}
