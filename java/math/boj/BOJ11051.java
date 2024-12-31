package math.boj;

// [이항 계수 2] https://www.acmicpc.net/problem/11051

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11051 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    System.out.println(getBinomial(n, k));
  }

  private static int getBinomial(int n, int k) {
    int[][] dp = new int[n + 1][k + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= Math.min(i, k); j++) {
        if (j == 0 || j == i) dp[i][j] = 1;
        else dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
      }
    }
    return dp[n][k];
  }
}
