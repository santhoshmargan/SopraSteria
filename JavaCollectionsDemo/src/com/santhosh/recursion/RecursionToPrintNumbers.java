package com.santhosh.recursion;

public class RecursionToPrintNumbers {

  public static void main(String[] args) {
    print(100);

  }
  
  public static void print(int n) {
    if(n>0) {
      print(n-1);
      System.out.print(n+" ");
    }
    
  }

}
