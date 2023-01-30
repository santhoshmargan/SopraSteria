package com.santhosh.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamDemo {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    
    List<Integer> list = new ArrayList<>();
    
    for(int i=1;i<100;i++) {
      list.add(i);
    }
    
    Stream<Integer> stream = list.stream();
    
    Stream<Integer> parallelStream = list.parallelStream();
    
    Stream<Integer> f1 = stream.filter(p->p>90);
    
    Stream<Integer> f2 = parallelStream.filter(p->p>90);
    
    f1.forEach(e -> System.out.println("Using stream: " +e +" "));
    
    f2.forEach(e->System.out.println("Using parallel stream: " +e+ " "));

  }

}
