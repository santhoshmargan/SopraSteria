package com.santhosh.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionDemo {
  
  static Comparator<Employee> comparator = new Comparator<>() {
    @Override
    public int compare(Employee o1, Employee o2) {
      return o1.getSalary().compareTo(o2.getSalary());
    }
  };
 
      public static void main(String[] args)
      {
        
        List<Employee> empList = new ArrayList<>();
        
        empList.add(new Employee(2,90000.0,"Santhosh"));
        empList.add(new Employee(3,22000.0,"Nithish"));
        empList.add(new Employee(1,40000.0,"Ravi"));
        empList.add(new Employee(4,30000.0,"Abraham"));
        
        List<Employee> result = empList.stream().sorted(comparator).limit(2).collect(Collectors.toList());
        for(int i=0; i<result.size();i++) {
          if(i==3)
            break;
          System.out.println(result.get(i));
         
        }
        
        /*
         * List<Employee> nameResult = empList.stream().sorted(new
         * NameComparator()).collect(Collectors.toList()); System.out.println("By name: ");
         * for(Employee e: nameResult) { System.out.println(e); }
         * 
         * List<Employee> idResult = empList.stream().sorted(new
         * IdComparator()).collect(Collectors.toList()); System.out.println("By Id: "); for(Employee
         * e: idResult) { System.out.println(e); }
         */
   
      }
  }

class NameComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    
    return o1.getName().compareTo(o2.getName());
  }
  
}

class IdComparator implements Comparator<Employee> {

  @Override
  public int compare(Employee o1, Employee o2) {
    
    return o1.getId() - o2.getId();
  }
  
}

class Employee {
  
  int id;
  Double salary;
  String name;
  
  public Employee(int id, Double salary, String name) {
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