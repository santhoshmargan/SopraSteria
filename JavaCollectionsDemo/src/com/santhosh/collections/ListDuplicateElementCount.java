package com.santhosh.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListDuplicateElementCount {

  public static void main(String[] args) {
    
    ArrayList<String> companies = new ArrayList<>();
    companies.add("Apple");
    companies.add("Google");
    companies.add("TCS");
    companies.add("Apple");
    companies.add("Capegemini");
    companies.add("Infosys");
    companies.add("Accenture");
    companies.add("TCS");
    
    // printing all list 
    companies.forEach(System.out::println);
    
    // filetering

    Map<String, Integer> duplicateCountMap = companies.stream()
        .collect(Collectors.toMap(Function.identity(), company -> 1, Integer::sum));
    
    duplicateCountMap.forEach((key,value)->System.out.println("Key: "+key+": Count ->"+value));
    

  }

}
