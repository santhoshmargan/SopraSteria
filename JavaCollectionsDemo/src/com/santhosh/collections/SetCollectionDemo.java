package com.santhosh.collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class SetCollectionDemo {

  public static void main(String[] args) {
    
    Set<String> set1 = new HashSet<String>();
    
    set1.add("One");
    set1.add("Two");
    set1.add("Three");
    
    Set<String> set2 = new HashSet<String>();
    set2.addAll(set1);
    set2.add("Four");
    Stream<String> stream = set2.stream();
    stream.forEach((element) -> {System.out.println("Set2 Elements are: "+element);});
    
    set1.removeAll(set2);

  }

}
