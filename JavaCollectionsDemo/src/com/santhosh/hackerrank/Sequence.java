package com.santhosh.hackerrank;

import java.util.Scanner;

public class Sequence {

      public static void main(StringSplitOperation []argh){
          Scanner in = new Scanner(System.in);
           int t=2;
          
          for(int i=0;i<t;i++){
              int a = 5;
              int b = 3;
              int n = 5;
              int result=a;
              for(int j=0;j<n;j++){
                  result =  result+ ((int) Math.pow(2,j)*b);
                  System.out.print(result+" ");
          }
              
          System.out.println();
          }
          in.close();
          
      }
  }
