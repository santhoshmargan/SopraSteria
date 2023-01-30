package com.santhosh.hackerrank;

import java.util.Scanner;

public class StringLexoGraphicalComparison {
  public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);
    String A=sc.next();
    String B=sc.next();
    /* Enter your code here. Print output to STDOUT. */
    int totalLen = A.length()+B.length();
    System.out.println(totalLen);
    
    int result = A.compareTo(B);
    if(result>0){
        System.out.println("Yes "+result);
    } else {
        System.out.println("No "+result);
    }
    
    String aUpperCased = A.substring(0, 1).toUpperCase().concat(A.substring(1));
    String bUpperCased = B.substring(0, 1).toUpperCase().concat(B.substring(1));
    System.out.println(aUpperCased+" "+bUpperCased);
}

}
