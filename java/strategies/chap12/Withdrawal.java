package strategies.chap12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import util.Input;

public class Withdrawal {

  static int n;
  static int k;
  static int[] r;
  static int[] c;


  public static void main(String[] args) {
    Scanner sc = Input.sc(new Withdrawal());

    int T = sc.nextInt();

    while (T-- > 0) {
      n = sc.nextInt();
      k = sc.nextInt();

      r = new int[n];
      c = new int[n];

      for (int i = 0; i < n; i++) {
        r[i] = sc.nextInt();
        c[i] = sc.nextInt();
      }

      System.out.println(optimize());
    }
  }

  private static double optimize() {
    double lo = -1e-9, hi = 1;
    for (int iter = 0; iter < 100; iter++) {
      double mid = (lo + hi) / 2;
      if (decision(mid)) {
        hi = mid;
      } else {
        lo = mid;
      }
    }
    return hi;
  }

  private static boolean decision(double average) {
    List<Double> v = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      v.add(average * c[i] - r[i]);
    }
    Collections.sort(v);
    double sum = 0;
    for (int i = n - k; i < n; i++) {
      sum += v.get(i);
    }
    return sum >= 0;
  }

}
