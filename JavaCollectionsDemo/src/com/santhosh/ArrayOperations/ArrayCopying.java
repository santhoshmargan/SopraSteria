package com.santhosh.ArrayOperations;

import java.util.Arrays;

public class ArrayCopying {

  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7,8,12,15};
    
    int copy[] = Arrays.copyOfRange(arr, 1, 4);
    
    for(int i : copy) {
      System.out.print(i +" ");
    }
  }

}
