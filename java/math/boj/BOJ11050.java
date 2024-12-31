package math.boj;

// [이항 계수 1] https://www.acmicpc.net/problem/11050

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11050 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int binomial = factorial(n) / factorial(k) / factorial(n - k);
    System.out.println(binomial);
  }

  private static int factorial(int n) {
    if (n <= 1) return 1;
    return n * factorial(n - 1);
  }
}
