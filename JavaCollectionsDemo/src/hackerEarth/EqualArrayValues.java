package hackerEarth;

import java.util.*;

class TestClass {
  public static void main(String args[]) throws Exception {
    int n, count = 0;
    boolean flag = true;

    Scanner s = new Scanner(System.in);
    n = s.nextInt();
    int a[] = new int[n];
    int b[] = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = s.nextInt();
    }
    for (int i = 0; i < n; i++) {
      b[i] = s.nextInt();
    }
    while (Arrays.stream(a).min().getAsInt() > -1) {
      int min = Arrays.stream(a).min().getAsInt();
      for (int i = 0; i < n; i++) {

        if (a[i] != min) {
          a[i] = a[i] - b[i];
          count++;
        }
      }
      HashSet<Integer> s1 = new HashSet<>();

      for (int i = 0; i < n; i++) {
        s1.add(a[i]);
      }

      if (s1.size() == 1) {
        flag = false;
        System.out.println(count + "\n");
        break;
      }
    }

    if (flag) {
      System.out.println(-1 + "\n");
    }

  }
}

