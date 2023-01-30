package com.santhosh.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

interface StringFunction{
  String run(String str);
}
public class Lambda {
  
  interface Function1 {
    void add(int a, int b);
  }

  interface Function2 {
    void multiply(int a, int b);
  }
  
  public void operate(int a, int b, Function1 obj) {
    obj.add(a, b);
  }

  public static void main(String[] args) {
    
    List<String> stringList = Arrays.asList("Santhosh","Margan","Sakthivel","Renuga");
    
    stringList.stream().map(a->a.toUpperCase()).forEach(System.out::println);
    
    Function1 f1Obj = (a,b)->System.out.println(a+b);
    Function1 f2Obj = (a,b)->System.out.println(a*b);
    
    ArrayList<Integer> list = new ArrayList<>();
    populateList(list);
    
    list.stream().map(a->Math.pow(a, a)).forEach(System.out::println);
    Lambda test = new Lambda();
    test.operate(2, 2, f1Obj);
    

    StringFunction s1 = s->s+"!";
    StringFunction s2 = s->s+"?";
    printFormattedString("Santhosh", s1);
    printFormattedString("Margan", s2);
    
  }
  
  public static void populateList(List<Integer> list) {
    int i=1;
    for(;i<=10;i++){
      list.add(i);
    }
  }
  
  public static void printFormattedString(String s, StringFunction function) {
    String result = function.run(s);
    System.out.println(result);
  }

}
