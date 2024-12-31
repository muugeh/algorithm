package divideandconquer.boj;

// [이항 계수 3] https://www.acmicpc.net/problem/11401

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11041 {

  private static final int MOD = 1_000_000_007;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    long numer = factorial(n);
    long denom = factorial(k) * factorial(n - k) % MOD;
    System.out.println(numer * pow(denom, MOD - 2) % MOD);
  }

  public static long factorial(long n) {
    long factorial = 1L;
    while (n > 1) {
      factorial = (factorial * n) % MOD;
      n--;
    }
    return factorial;
  }

  public static long pow(long base, long expo) {
    long result = 1;
    while (expo > 0) {
      if (expo % 2 == 1) {
        result *= base;
        result %= MOD;
      }
      base = (base * base) % MOD;
      expo /= 2;
    }
    return result;
  }
}
