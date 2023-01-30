package com.santhosh.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatterningMap {

  public static void main(String[] args) {
    
    Map<Integer,List<Integer>> map = new HashMap<>();
    
    map.put(1, Arrays.asList(1,2));
    map.put(2, Arrays.asList(3,4,5));
    map.put(3, Arrays.asList(6,7));
    map.put(4, Arrays.asList(8,9));

    List<Integer> resultList = flatternMap(map.values());
    
   System.out.println(resultList);
  }

  private static List<Integer> flatternMap(Collection<List<Integer>> collection) {
    List<Integer> result = new ArrayList<>();
    for(List<Integer> temp : collection) {
      temp.forEach(result::add);
      
    }
    return result;
  }

}
