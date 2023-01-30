package com.santhosh.hackerrank;

import java.util.Scanner;

public class Palindrome {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    String A = sc.next();
    sc.close();
    /* Enter your code here. Print output to STDOUT. */
    String result = "";
    int length = A.length();
    for (int i = length - 1; i >= 0; i--) {
      result = result.concat(String.valueOf(A.charAt(i)));
    }
    if (result.equals(A)) {
      System.out.println("Yes");
    } else {
      System.out.println("No");
    }
  }



}
