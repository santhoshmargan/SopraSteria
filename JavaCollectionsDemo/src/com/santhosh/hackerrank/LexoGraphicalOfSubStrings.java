package com.santhosh.hackerrank;

import java.util.Scanner;

public class LexoGraphicalOfSubStrings {
  public static String getSmallestAndLargest(String s, int k) {
    String smallest = "";
    String largest = "";

    int n = Math.min(s.length(), k);

    smallest = largest = s.substring(0, k);

    for (int i = 1; i < s.length() - k + 1; i++) {
      String substr = s.substring(i, i + k);
      if (smallest.compareTo(substr) > 0)
        smallest = substr;
      if (largest.compareTo(substr) < 0)
        largest = substr;
    }


    return smallest + "\n" + largest;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = "welcometojava";
    int k = 3;
    scan.close();

    System.out.println(getSmallestAndLargest(s, k));
  }

}
