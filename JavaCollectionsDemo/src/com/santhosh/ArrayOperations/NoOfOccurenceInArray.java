package com.santhosh.ArrayOperations;

public class NoOfOccurenceInArray {

  public static void main(String[] args) {

    int arr[] = {1, 1, 2, 2, 2, 3, 3, 3, 3, 4, 5, 6, 7, 8};
    int count = 0, x = 2;
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == x) {
        count++;
      }
    }
    System.out.println(x + " occured " + count + " times");

  }

}
