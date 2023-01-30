package com.santhosh.hackerrank;

import java.util.ArrayList;
import java.util.Scanner;

public class StringSplitOperation {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    if (!scan.hasNext()) {
      System.out.println(0);
    } else {
      String s = scan.nextLine();
      String[] result = s.trim().split("[ !,?._'@]+");
      ArrayList<String> list = new ArrayList<>(java.util.Arrays.asList(result));
      System.out.println(list.size());
      for (String temp : list) {
        System.out.println(temp);
      }
    }
    scan.close();
  }

}
