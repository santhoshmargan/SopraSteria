package com.santhosh.hackerrank;

import java.util.Arrays;
import java.util.Scanner;

public class AnagramExample {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1 = sc.next();
    String s2 = sc.next();
    if(findAnagram(s1,s2)) {
      System.out.println("Yes");
    } else {
    System.out.println("No");
    }
    sc.close();
  }
  
  public static boolean findAnagram(String s1, String s2) {
  if(s1.length() == s2.length()) {
    char[] s1CharArray = s1.toCharArray();
    char[] s2CharArray = s2.toCharArray();
    
    Arrays.sort(s1CharArray);
    Arrays.sort(s2CharArray);
    
    if(Arrays.equals(s1CharArray, s2CharArray)) {
      return true;
    } else {
      return false;
    }
    
  } else {
    return false;
  }
  }

}
