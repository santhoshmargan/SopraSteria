package com.santhosh.stream;

import java.util.Arrays;

public class ArraysWithStream {

  public static void main(String[] args) {
    int a[] = {1,2,3,4,5,6,7,8,9,9,1,2};
    int sum =Arrays.stream(a).sum();
    System.out.println("Sum: " + sum);

    double average = Arrays.stream(a).average().orElseThrow();
    System.out.println("Average: " + average);

    int min = Arrays.stream(a).min().orElseThrow();
    System.out.println("Minimum: " + min);

    int max = Arrays.stream(a).max().orElseThrow();
    System.out.println("Maximum: " + max);
    
    Arrays.stream(a).distinct().forEach(System.out::print);
  }

}
