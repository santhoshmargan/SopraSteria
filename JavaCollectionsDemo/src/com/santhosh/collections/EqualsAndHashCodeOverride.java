package com.santhosh.collections;

public class EqualsAndHashCodeOverride {

  public static void main(String[] args) {
    
    String[] str = {"Santhosh","Sargan","Renuga","Sakthivel"};
    int i =0, count=0;
    for(String s : str) {
      
      if(s.startsWith("S")) {
        count++;
      }
    }
    System.out.println("No of elements starting with S count are "+count);
    
    
    String one  = new String("Santhosh");
    String two =new String("Santhosh");
    
    if(one.equals(two))
    {
      System.out.println("one and two hashcodes are Equal : "+one.hashCode()+" : " +two.hashCode());
    } else {
      System.out.println("one and two hashcodes are not Equal : "+one.hashCode()+" : " +two.hashCode());
    }
    
    EqualsMethodClass obj1 = new EqualsMethodClass(0,0);
    EqualsMethodClass obj2 = new EqualsMethodClass(0,0);

    if (obj1.equals(obj2)) {
      System.out.println("obj1 and obj2 are equal! " +obj1.hashCode() +" "+obj2.hashCode());

    } else if (!(obj1.equals(obj2))) {
      System.out.println("obj1 and obj2 are not equal!! "+obj1.hashCode() +" "+obj2.hashCode());
    }
  }

}

class EqualsMethodClass {

  int age;
  int salary;

  public EqualsMethodClass(int age, int salary) {
    this.age = age;
    this.salary = salary;
  }

 /* @Override
  public boolean equals(Object obj) {

    if (!(obj instanceof EqualsMethodClass)) {
      return false;
    }
    if (this == obj) {
      return true;
    }

    EqualsMethodClass object = (EqualsMethodClass) obj;
    if (this.age == object.age && this.salary == object.salary) {
      return true;
    }

    return false;
  }*/
}