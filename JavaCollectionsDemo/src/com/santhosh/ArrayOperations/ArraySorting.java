package com.santhosh.ArrayOperations;

import java.util.Arrays;

public class ArraySorting {

  public static void main(String[] args) {
    int arr[] = {21,22,10,11,9,43,8,33,54,16};
    // Arrays.sort(arr);
    
    
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
        i = -1;
      }

    }

    Arrays.stream(arr).forEach(System.out::println);

  }

}
