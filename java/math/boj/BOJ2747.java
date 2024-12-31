package math.boj;

// [피보나치 수] https://www.acmicpc.net/problem/2747

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2747 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    System.out.println(fibonacci(n));
  }

  private static int[] dp = new int[46];

  private static int fibonacci(int n) {
    dp[0] = 0;
    dp[1] = 1;
    for(int i = 2; i <= n; i++){
      dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
  }
}
