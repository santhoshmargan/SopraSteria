package com.santhosh.collections;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableDemo {

      public static class Person implements Serializable {
          public String name = null;
          public int    age  =   0;
      }


      public static void main(String[] args) throws IOException, ClassNotFoundException {

          ObjectOutputStream objectOutputStream =
              new ObjectOutputStream(new FileOutputStream("C:\\Users\\smargan\\Downloads\\person.bin"));

          Person person = new Person();
          person.name = "Jakob Jenkov";
          person.age  = 40;

          objectOutputStream.writeObject(person);
          objectOutputStream.close();


          ObjectInputStream objectInputStream =
              new ObjectInputStream(new FileInputStream("C:\\Users\\smargan\\Downloads\\person.bin"));

          Person personRead = (Person) objectInputStream.readObject();

          objectInputStream.close();

          System.out.println(personRead.name);
          System.out.println(personRead.age);
      }
  }
