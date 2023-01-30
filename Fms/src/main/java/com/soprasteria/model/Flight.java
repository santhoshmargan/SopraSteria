package com.soprasteria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Flight {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String airlineName;
  private String flightCode;
  private Integer seatCapacity;
  private Double price;
  private Boolean freeMeal;
  private Boolean available;
  private String result;
  private String numberOfStops;
  private String seatsAvailable;
  private String source;
  private String destination;

  public Integer getId() {
    return id;
  }

  public String getAirlineName() {
    return airlineName;
  }

  public void setAirlineName(String airlineName) {
    this.airlineName = airlineName;
  }

  public String getFlightCode() {
    return flightCode;
  }

  public void setFlightCode(String flightCode) {
    this.flightCode = flightCode;
  }

  public Integer getSeatCapacity() {
    return seatCapacity;
  }

  public void setSeatCapacity(Integer seatCapacity) {
    this.seatCapacity = seatCapacity;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Boolean getFreeMeal() {
    return freeMeal;
  }

  public void setFreeMeal(Boolean freeMeal) {
    this.freeMeal = freeMeal;
  }

  public Boolean getAvailable() {
    return available;
  }

  public void setAvailable(Boolean available) {
    this.available = available;
  }

  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public String getNumberOfStops() {
    return numberOfStops;
  }

  public void setNumberOfStops(String numberOfStops) {
    this.numberOfStops = numberOfStops;
  }

  public String getSeatsAvailable() {
    return seatsAvailable;
  }

  public void setSeatsAvailable(String seatsAvailable) {
    this.seatsAvailable = seatsAvailable;
  }

  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }

  @Override
  public String toString() {
    return "Flight [number=" + id + ", airlineName=" + airlineName + ", flightCode="
        + flightCode + ", seatCapacity=" + seatCapacity + ", price=" + price + ", freeMeal="
        + freeMeal + ", result=" + result + ", numberOfStops=" + numberOfStops + ", seatsAvailable="
        + seatsAvailable + ", source=" + source + ", destination=" + destination + "]";
  }


}
