package com.santhosh.abstraction;

// abstract class - may contain 0 or more abstract methods in it
// We can't create object for abstract class, because it may not have implementations in child classes
public abstract class Vehicle {
  
  // abstract methods
  public abstract int getNoOfWheels();
  public abstract String getModel();
  

}

// Child classes must provide implementation for parent class abstract methods
class Car extends Vehicle {
  
  public int getNoOfWheels() {
    return 4;
  }

  public String getModel() {
    return null;
  }
}

class Bus extends Vehicle {
  
  public int getNoOfWheels() {
    return 6;
  }

  public String getModel() {
    return null;
  }
}

class Test {
  public static void main(String[] args) {
    Car c = new Car();
    c.getNoOfWheels();
    c.getModel();
    
    Bus b = new Bus();
    b.getNoOfWheels();
    b.getModel();
      
     
  }
}