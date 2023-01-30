package com.santhosh.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

  public static void main(String[] args) {
    Map<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1, "Santhosh");
    hashMap.put(2, "Gandhi");
    hashMap.put(3, "Anand");
    hashMap.put(4, "Tirumal");
    hashMap.put(5, "Yammer");
    
    System.out.println(hashMap);

    System.out.println(hashMap.entrySet());
    
    System.out.println(hashMap.keySet());
    
    System.out.println(hashMap.values());
    
    System.out.println(hashMap.containsKey(6));
    
    System.out.println(hashMap.containsValue("Santhosh"));
    
    
  }

}
