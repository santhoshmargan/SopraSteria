package hackerEarth;

public class PalindromeNumber {

  public static void main(String[] args) {

    palindromeOrNot(141);

  }

  private static void palindromeOrNot(int n) {
    int rem = 0, sum = 0, temp = n;

    while (n > 0) {
      rem = n % 10;
      sum = (sum * 10) + rem;
      n = n / 10;
    }

    if (temp == sum) {
      System.out.println(temp + " is a palindrome number");
    } else {
      System.out.println(temp + " is not a palindrome number");
    }

  }

}
