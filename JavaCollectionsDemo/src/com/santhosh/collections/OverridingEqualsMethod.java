package com.santhosh.collections;

public class OverridingEqualsMethod {

  private double re, im;

  public OverridingEqualsMethod(double re, double im) {
    this.re = re;
    this.im = im;
  }

  // Overriding equals() to compare two Complex objects
  @Override
  public boolean equals(Object o) {

    // If the object is compared with itself then return true
    if (o == this) {
      return true;
    }

    /*
     * Check if o is an instance of Complex or not "null instanceof [type]" also returns false
     */
    if (!(o instanceof OverridingEqualsMethod)) {
      return false;
    }

    // typecast o to Complex so that we can compare data members
    OverridingEqualsMethod c = (OverridingEqualsMethod) o;

    // Compare the data members and return accordingly
    return Double.compare(re, c.re) == 0 && Double.compare(im, c.im) == 0;
  }
}
 
// Driver class to test the Complex class
class Main {
 
    public static void main(String[] args) {
      OverridingEqualsMethod c1 = new OverridingEqualsMethod(10, 15);
      OverridingEqualsMethod c2 = new OverridingEqualsMethod(10, 15);
        if (c1.equals(c2)) {
            System.out.println("Equal ");
        } else {
            System.out.println("Not Equal ");
        }
    }
}
