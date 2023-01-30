package com.santhosh.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CollectionRemoveIfMethod {

  public static void main(String[] args) {
    
    Collection<Character> collection = new ConcurrentLinkedQueue<Character>();
   char c;
   
   for(c='A';c<='Z';c++) {
     collection.add(c);
   }
    
   collection.removeIf(a -> (a!='A' && a!='E' && a!='I' && a!='O' && a!='U'));
    
    System.out.println(collection);
    
   

  }

}
