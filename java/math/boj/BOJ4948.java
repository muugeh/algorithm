package math.boj;

// [베르트랑 공준] https://www.acmicpc.net/problem/4948

import java.io.*;
import java.util.Arrays;

public class BOJ4948 {
  private static final int MAX = 123456 * 2;
  private static boolean[] prime = new boolean[MAX + 1];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    checkPrime();
    while (true) {
      int n = Integer.parseInt(br.readLine());
      if (n == 0) break;
      bw.write(getCount(n) + "\n");
    }
    bw.flush();
    bw.close();
    br.close();
  }

  private static int getCount(int n) {
    int count = 0;
    for (int i = n + 1; i <= 2 * n; i++)
      if (prime[i]) count++;
    return count;
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
