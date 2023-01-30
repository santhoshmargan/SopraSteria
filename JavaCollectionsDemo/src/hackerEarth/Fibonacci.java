package hackerEarth;

public class Fibonacci {
  
 /* int a=10;
  static int b=20;
  

  public static void main(String[] args) {
    Fibonacci  fib = new Fibonacci();
    
    Fibonacci fib1 = new Fibonacci();
    
    fib.a=40;
    fib.b=30;
    
    fib1.a=20;
    fib1.b=35;
    
    System.out.println(fib.a+" "+fib.b);
    System.out.println(fib1.a+" "+fib1.b);
    
    */
    static int i = 10;
    int j = 10;
 
    public static void main(String[] args)
    {
        // Creating new Object
      Fibonacci test = new Fibonacci();
        test.i = i + 10;
        test.j = test.j + 10;
 
        // Creating another Object
        Fibonacci anotherTest = new Fibonacci();
        anotherTest.i = i + 80;
        anotherTest.j = anotherTest.j + 80;
 
        System.out.println("Value from test object i == " + test.i + ", j ==  " + test.j);
        System.out.println("Value from Another object i == " + anotherTest.i + ", j ==  " + anotherTest.j);
    }
 
    

  }

