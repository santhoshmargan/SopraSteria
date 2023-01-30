package com.santhosh.threadExamples;

import java.util.ArrayList;
import java.util.List;

public class CreatingThreadDemo implements Runnable {
  
  private long count;
  
  public CreatingThreadDemo(long count) {
   this.count=count;
  }
 
  public static void main(String[] args) {
    List<Thread> threads = new ArrayList<>();
        for(int i=0;i<500;i++) {
      Runnable runnable = new CreatingThreadDemo(100000L+i);
      Thread newThread = new Thread(runnable);
      newThread.start();
      threads.add(newThread);
        }
        int running=0;
     do {
       running=0;
      
       for(Thread thread : threads) {
         if(thread.isAlive()) {
         System.out.println("My current running thread :"+thread.getName());
         running++;
       }
     }
     }while(running>0);
      

    AdditionThread addition = new AdditionThread(20,10);
    MultiplyThread multiply = new MultiplyThread(14, 15);
    Thread t2 = new Thread(addition);
    t2.start();
    multiply.start();

  }

  @Override
  public void run() {
    long sum =0;
    for(int i=0;i<count;i++) {
      sum+=i;
    }
    System.out.println(sum);
    
  }

}

class AdditionThread implements Runnable {
  private int a;
  private int b;
  
  public AdditionThread(int a, int b) {
    this.a=a;
    this.b=b;
  }
  public int getA() {
    return a;
  }
  public void setA(int a) {
    this.a = a;
  }
  public int getB() {
    return b;
  }
  public void setB(int b) {
    this.b = b;
  }
  @Override
  public void run() {
    System.out.println("Addition result of a & b is:" +(int) this.getA()+ (int) this.getB());
    
  }
  
}

class MultiplyThread extends Thread{
  private int a;
  private int b;
  
  public MultiplyThread(int a, int b) {
    this.a=a;
    this.b=b;
  }
  public int getA() {
    return a;
  }
  public void setA(int a) {
    this.a = a;
  }
  public int getB() {
    return b;
  }
  public void setB(int b) {
    this.b = b;
  }
  @Override
  public void run() {
    System.out.println("Multiplication result of a & b is:" +this.getA()*this.getB());
    
  }
  
}