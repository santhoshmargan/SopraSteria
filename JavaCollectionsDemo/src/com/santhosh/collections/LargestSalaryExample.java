package com.santhosh.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LargestSalaryExample {

  static Comparator<Employees> comparator = new Comparator<>() {

    @Override
    public int compare(Employees o1, Employees o2) {
      // TODO Auto-generated method stub
      return o1.getSalary().compareTo(o2.getSalary());
    }

  };

  public static void main(String[] args) {

    List<Employees> list = new ArrayList<>();

    list.add(new Employees(2, 60000.0, "Manoj"));
    list.add(new Employees(1, 20000.0, "Santhosh"));
    list.add(new Employees(3, 50000.0, "Thangavelu"));
    list.add(new Employees(4, 30000.0, "Kumaran"));
    list.add(new Employees(8, 10000.0, "Jason"));
    list.add(new Employees(7, 90000.0, "Arun"));
    list.add(new Employees(5, 70000.0, "Margan"));
    list.add(new Employees(6, 40000.0, "Deva"));

    System.out.println("**************Sorted By Salary****************");
    list.stream().sorted(comparator).collect(Collectors.toList()).forEach(System.out::println);

    System.out.println("**************Sorted By Name****************");
    list.stream().sorted(new SalaryComparator()).collect(Collectors.toList())
        .forEach(System.out::println);

    // Double temp=0.0;
    /*
     * for (int i = 0; i < list.size()-1; i++) { if (list.get(i).getSalary() < list.get(i +
     * 1).getSalary()) { temp = list.get(i).getSalary(); list.get(i).setSalary(list.get(i +
     * 1).getSalary()); list.get(i+1).setSalary(temp); i = -1; } }
     */
    /*
     * for (Employees emp : list) { System.err.println(emp); }
     */
  }



}


class SalaryComparator implements Comparator<Employees> {

  @Override
  public int compare(Employees o1, Employees o2) {

    return o1.getName().compareTo(o2.getName());
  }

}


class Employees {

  int id;
  Double salary;
  String name;

  public Employees(int id, Double salary, String name) {
    super();
    this.id = id;
    this.salary = salary;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Employee [id=" + id + ", salary=" + salary + ", name=" + name + "]";
  }

}
