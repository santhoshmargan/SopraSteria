package hackerEarth;


import java.util.Scanner;

public class SumOfMinInLong {

  public static void main(String[] args) {
    
     Scanner sc = new Scanner(System.in);
     long a = sc.nextLong();
     int count=0;
     long temp = a;
     while(temp!=0) {
       temp/=10;
       count++;
     }
     long array[] = new long[count];
     
     String str="";
       for(int i =0;i<count;i++) {
         if(a==0)
           break;
         str= str+String.valueOf(a%10);
         a/=10;
     } 
       long toReverse = Long.valueOf(str);
       long rem=0;
       int k=0;
       long reverse=0;
       while(toReverse !=0) {
        rem = toReverse%10;
        reverse = reverse*10+rem;
        array[k] = reverse;
        k++;
        toReverse/=10;
     } 
       
       
     // 1234 ==> 12 + 34 = 46, 43+21=64, 13+24=37
     String  s1="",s2="";
     
     for(int i=0;i<array.length;i++) {
       String temp1 = String.valueOf(array[i]);
       if(i%2 == 0)
         s1=s1+temp1;
       else 
         s2=s2+temp1;
       
     }
     
     long v1 = Long.valueOf(s1);
     long v2 = Long.valueOf(s2);
     System.out.println(v1+v2);
    // Collections.sort(longList);
     //System.out.println(longList.get(0));
     sc.close();
     
  }

}
