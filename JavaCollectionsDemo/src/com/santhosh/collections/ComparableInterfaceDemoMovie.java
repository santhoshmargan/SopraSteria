package com.santhosh.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableInterfaceDemoMovie implements Comparable<ComparableInterfaceDemoMovie>{
  
  private int year;
  private double rating;
  private String name;
  
  public ComparableInterfaceDemoMovie(int year, double rating, String name) {
    super();
    this.year = year;
    this.rating = rating;
    this.name = name;
  }

  public int getYear() {
    return year;
  }

  public double getRating() {
    return rating;
  }

  public String getName() {
    return name;
  }

  public static void main(String[] args) {
    
    List<ComparableInterfaceDemoMovie> list = new ArrayList<>();
    list.add(new ComparableInterfaceDemoMovie(1989,4,"Viswasam"));
    list.add(new ComparableInterfaceDemoMovie(1987,4.5,"Gemini"));
    list.add(new ComparableInterfaceDemoMovie(1999,3.5,"English Rule"));
    list.add(new ComparableInterfaceDemoMovie(1995,2.5,"Mona Mona"));
    list.add(new ComparableInterfaceDemoMovie(1997,2,"Royal Indian"));

    Collections.sort(list);
    
    list.stream().forEach(System.out::println);
  }

  @Override
  public int compareTo(ComparableInterfaceDemoMovie o) {
    return this.name.compareTo(o.name);
  }

  @Override
  public String toString() {
    return "ComparableInterfaceDemoMovie [year=" + year + ", rating=" + rating + ", name=" + name
        + "]";
  }

}

