package com.santhosh.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AspireQuestion {
  
  public static void main(String[] args) {
    List<Emp> emp = new ArrayList<>();
    
    emp.add(new Emp(1,"Santhosh",20000.0,"Manager","001"));
    emp.add(new Emp(2,"Manoj",10000.0,"CEO","002"));
    emp.add(new Emp(3,"Nithisha",10000.0,"Assitant-Manager","001"));
    emp.add(new Emp(4,"Uma mageshwari",30000.0,"Manager","001"));
    emp.add(new Emp(1,"Nalini",10000.0,"Manager","003"));

    List<Emp> uniqueEmp = emp.stream().distinct().collect(Collectors.toList());

    List<Emp> result = uniqueEmp.stream().filter(e->"Manager".equalsIgnoreCase(e.getDesignation()))
                                .collect(Collectors.toList());
                                
                                
    result.stream().sorted(new SalaryComparatorOne()).forEach(System.out::println);

  }
}
 

 class SalaryComparatorOne implements Comparator<Emp>{

   @Override
  public int compare(Emp o1, Emp o2){
  return (int) (o1.getSalary() -o2.getSalary());
  }

}
