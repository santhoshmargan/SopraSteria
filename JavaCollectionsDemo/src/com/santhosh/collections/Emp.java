package com.santhosh.collections;

import java.util.Objects;

public class Emp {
  
  private int id;
  private String name;
  private double salary;
  private String designation;
  private String orgId;
  
  
  @Override
  public String toString() {
    return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + ", designation="
        + designation + ", orgId=" + orgId + "]";
  }
  public Emp(int id, String name, double salary, String designation, String orgId) {
    super();
    this.id = id;
    this.name = name;
    this.salary = salary;
    this.designation = designation;
    this.orgId = orgId;
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Emp other = (Emp) obj;
    return id == other.id;
  }
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public double getSalary() {
    return salary;
  }
  public void setSalary(double salary) {
    this.salary = salary;
  }
  public String getDesignation() {
    return designation;
  }
  public void setDesignation(String designation) {
    this.designation = designation;
  }
  public String getOrgId() {
    return orgId;
  }
  public void setOrgId(String orgId) {
    this.orgId = orgId;
  }
  
  
  

}
