package math.boj;

// [골드바흐의 추측] https://www.acmicpc.net/problem/9020

import java.io.*;
import java.util.Arrays;

public class BOJ9020 {

  private static final int MAX = 10000;
  private static boolean[] prime = new boolean[MAX + 1];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int t = Integer.parseInt(br.readLine());
    checkPrime();
    while (t-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] goldBach = getGoldBach(n);
      bw.write(goldBach[0] + " " + goldBach[1] + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static int[] getGoldBach(int n) {
    int lo = n / 2;
    int hi = n / 2;
    while (lo >= 2 && hi < n) {
      if (prime[lo] && prime[hi])
        break;
      lo--;
      hi++;
    }
    return new int[]{lo, hi};
  }

  private static void checkPrime() {
    Arrays.fill(prime, true);
    prime[0] = prime[1] = false;
    for (int i = 2; i * i <= MAX; i++) {
      for (int j = i * i; j <= MAX; j += i) {
        prime[j] = false;
      }
    }
  }

}
