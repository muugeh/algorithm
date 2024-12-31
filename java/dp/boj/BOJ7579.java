package dp.boj;

// [앱] https://www.acmicpc.net/problem/7579

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ7579 {

  private static int n, m;
  private static int[] memories;
  private static int[] costs;
  private static int[] dp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    memories = new int[n];
    costs = new int[n];
    dp = new int[10001];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      memories[i] = Integer.parseInt(st.nextToken());
    }
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      costs[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.fill(dp, -1);

    for (int i = 0; i < n; i++) {
      int cost = costs[i];
      for (int j = 10000; j >= cost; j--) {
        if (dp[j - cost] != -1) {
          dp[j] = Math.max(dp[j], dp[j - cost] + memories[i]);
        }
      }
      dp[cost] = Math.max(dp[cost], memories[i]);
    }

    for (int i = 0; i < 10001; i++) {
      if (dp[i] >= m) {
        System.out.println(i);
        break;
      }
    }
  }
}
