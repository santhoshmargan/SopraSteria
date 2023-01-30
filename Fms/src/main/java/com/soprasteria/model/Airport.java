package com.soprasteria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Airport {

  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Integer id;
  private String code;
  private String name;
  private String cityCode;
  private String cityName;
  private String countryName;
  private String countryCode;
  private String timezone;
  private String lat;
  private String lon;
  private String numAirports;
  private String city;

  public Integer getId() {
    return id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCityCode() {
    return cityCode;
  }

  public void setCityCode(String cityCode) {
    this.cityCode = cityCode;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCountryName() {
    return countryName;
  }

  public void setCountryName(String countryName) {
    this.countryName = countryName;
  }

  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public String getTimezone() {
    return timezone;
  }

  public void setTimezone(String timezone) {
    this.timezone = timezone;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  public String getLon() {
    return lon;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }

  public String getNumAirports() {
    return numAirports;
  }

  public void setNumAirports(String numAirports) {
    this.numAirports = numAirports;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "Airport [id=" + id + ", code=" + code + ", name=" + name + ", cityCode="
        + cityCode + ", cityName=" + cityName + ", countryName=" + countryName + ", countryCode="
        + countryCode + ", timezone=" + timezone + ", lat=" + lat + ", lon=" + lon
        + ", numAirports=" + numAirports + ", city=" + city + "]";
  }


}
