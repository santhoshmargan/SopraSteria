package com.santhosh.hackerrank;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;

public class DayofWeekDemo {

  public static void main(String[] args) {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING. The function accepts following parameters: 1.
     * INTEGER month 2. INTEGER day 3. INTEGER year
     */

    System.out.print(findDay(8, 20, 1997));


  }
  public static String findDay(int month, int day, int year) {
    LocalDate localDate = LocalDate.of(year, month, day);
    return localDate.getDayOfWeek().toString();

  }

}
