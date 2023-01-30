package com.santhosh.collections;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class CommandLineArgsDemo {
  
  public static void main(String[] args) throws IOException {
    
    OutputStream output = new FileOutputStream("C:\\Users\\smargan\\Downloads\\system.out.txt");
    PrintStream printOut = new PrintStream(output);

    System.setOut(printOut);
    
    System.out.println("Welcome Santhosh");
    

    System.out.flush();
    System.out.close();
    System.err.println("Welcome Santhosh");
  }

}
