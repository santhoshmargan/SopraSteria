package com.santhosh.hackerrank;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatDemo {

  public static void main(String[] args) {
    
    double payment =1234.124;
    
    NumberFormat nF = NumberFormat.getCurrencyInstance(Locale.US);
    String us = nF.format(payment);
    
    NumberFormat nFChina = NumberFormat.getCurrencyInstance(Locale.CHINA);
    String china = nFChina.format(payment);

    NumberFormat nFFrance = NumberFormat.getCurrencyInstance(Locale.FRANCE);
    String france = nFFrance.format(payment);   
    
    NumberFormat nFndia = NumberFormat.getCurrencyInstance(new Locale("en", "IN"));
    String india = nFndia.format(payment);   
       
       System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);

  }

}
