package com.santhosh.patterns;

public class LeftAngledTriangle {

  public static void main(String[] args) {
    
   for(int i=0;i<10;i++) {

     for(int k=2*(10-i);k>=0;k--) {
       System.out.print(" ");
     }
     for(int j=0;j<=i;j++) {
       System.out.print("* ");
     }
     System.out.println();
   }

  }

}
