package hackerEarth;

public class PrimeNumber {
  
  
  static void getPrimeOrNot(int n){
    int m=0,flag=0;
    
    if(n==0 || n==1) {
      System.out.println(n + " is not a prime number");
    }
    
    m = n/2;
    
    for(int i=2;i<=m;i++) {
      if(n%i==0) {
        flag=1;
        System.out.println(n + " is not a prime number");
        break;
      }
    }
    
    if(flag == 0) {
      System.out.println(n + " is a prime number");
    }
    
  }

  public static void main(String[] args) {
    getPrimeOrNot(7);

  }

}
