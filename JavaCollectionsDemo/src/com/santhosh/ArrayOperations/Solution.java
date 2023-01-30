package com.santhosh.ArrayOperations;

public class Solution {

  public static void main(String[] args) {
    int i=0,j=1,k;
    System.out.print(i+" "+j);
    for(int m=2;m<15;m++) {
      k=i+j;
      System.out.print(" "+k);
      i=j;
      j=k;
    }
  }}

// 0,1,1,2,3,5,8,13
