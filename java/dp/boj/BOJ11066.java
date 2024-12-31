package dp.boj;

// [파일 합치기] https://www.acmicpc.net/problem/11066

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11066 {

  private static int k;
  private static int[] chapters;
  private static int[] sum;
  private static int[][] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    while (t-- > 0) {
      k = Integer.parseInt(br.readLine());
      dp = new int[k + 2][k + 2];
      sum = new int[k + 1];
      chapters = new int[k + 1];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 1; i <= k; i++) {
        chapters[i] = Integer.parseInt(st.nextToken());
        sum[i] = sum[i - 1] + chapters[i];
        dp[i - 1][i] = 0;
      }

      add();
      System.out.println(dp[1][k]);
    }

    br.close();
  }

  private static int add() {
    for (int i = 2; i <= k; i++) {
      for (int j = i - 1; j > 0; j--) {
        dp[j][i] = Integer.MAX_VALUE;
        for (int m = j; m <= i; m++) {
          dp[j][i] = Math.min(dp[j][i], dp[j][m] + dp[m + 1][i]);
        }
        dp[j][i] += (sum[i] - sum[j - 1]);
      }
    }

    return 0;
  }
}
