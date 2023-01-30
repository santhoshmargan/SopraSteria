package com.santhosh.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFirstFailSafe {

  public static void main(String[] args) {
    
    /*
     * List<String> list = new CopyOnWriteArrayList<>();
     * 
     * list.add("a"); list.add("b");
     * 
     * Iterator<String> iterator = list.iterator();
     * 
     * while(iterator.hasNext()) { String s = iterator.next(); System.out.println(s); list.add("c");
     * }
     */
    
    Map<Integer, String> map = new ConcurrentHashMap<>();
    
    map.put(1, "one");
    map.put(2, "two");
    
    Iterator<Integer> iterator = map.keySet().iterator();
   
    while(iterator.hasNext()) {
      Integer i = iterator.next();
      System.out.println(i);
      map.put(3, "three");
      
    }

  }

}
