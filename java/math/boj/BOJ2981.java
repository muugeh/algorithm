package math.boj;

// [검문] https://www.acmicpc.net/problem/2981

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BOJ2981 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);

    int gcd = arr[1] - arr[0];
    for (int i = 2; i < n; i++) {
      gcd = gcd(gcd, arr[i] - arr[i - 1]);
    }

    List<Integer> factors = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= Math.sqrt(gcd); i++) {
      if (i * i == gcd) factors.add(i);
      else if (gcd % i == 0) {
        factors.add(i);
        factors.add(gcd / i);
      }
    }
    Collections.sort(factors);

    for (int factor : factors) sb.append(factor).append(" ");
    sb.append(gcd);
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  private static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);
  }
}
