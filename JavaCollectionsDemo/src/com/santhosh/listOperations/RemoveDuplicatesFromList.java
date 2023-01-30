package com.santhosh.listOperations;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesFromList {
  
  static List<Integer> removeDuplicates(List<Integer> list) {
    ArrayList<Integer> newList = new ArrayList<>();
    if(list.size()>0) {
      for(Integer temp : list) {
        if(!newList.contains(temp)) {
          newList.add(temp);
        }
      }
      return newList;
    }
    return list;
    
  }

  public static void main(String[] args) {
    
    List<Integer> list = List.of(1,2,3,1,2,3,4,5,6,7,8,9,10);
    List<Integer> result = removeDuplicates(list);
    
    result.stream().forEach(System.out::print);

  }

}
