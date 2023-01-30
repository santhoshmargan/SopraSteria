package com.soprasteria.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Schedule {
	
	@Id
	private String sheduledId;
	private String arrDateTime;
	private String depDateTime;
	private String destinationAirport;
	private String other;
	private Boolean prime;
	private String result;
	private String srcAirport;
	
	public String getSheduledId() {
		return sheduledId;
	}
	public void setSheduledId(String sheduledId) {
		this.sheduledId = sheduledId;
	}
	public String getArrDateTime() {
		return arrDateTime;
	}
	public void setArrDateTime(String arrDateTime) {
		this.arrDateTime = arrDateTime;
	}
	public String getDepDateTime() {
		return depDateTime;
	}
	public void setDepDateTime(String depDateTime) {
		this.depDateTime = depDateTime;
	}
	public String getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(String destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
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
	public String getSrcAirport() {
		return srcAirport;
	}
	public void setSrcAirport(String srcAirport) {
		this.srcAirport = srcAirport;
	}
	
	
	
	

}
