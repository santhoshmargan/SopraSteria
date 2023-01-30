package com.santhosh.ArrayOperations;

import java.util.Arrays;

public class ReverseAnArray {

  public static void main(String[] args) {
    
    int arr[] = {4,3,2,1};
    int result[] = new int[arr.length];
    int k=0;
    
    for(int i=arr.length-1;i>=0;i--) {
      result[k] = arr[i];
      k++;
    }
    
    Arrays.stream(result).forEach(System.out::print);
      

  }

}
