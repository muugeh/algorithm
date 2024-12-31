package dp.boj;

// [평범한 배낭] https://www.acmicpc.net/problem/12865

import java.io.*;
import java.util.StringTokenizer;

public class BOJ12865 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] weight = new int[n+1];
    int[] value = new int[n+1];
    for(int i = 1; i <= n; i++) {
      st = new StringTokenizer(br.readLine());
      int w = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());
      weight[i] = w;
      value[i] = v;
    }
    bw.write(String.valueOf(solve(n, k, weight, value)));
    bw.flush();
    bw.close();
    br.close();
  }

  private static int[][] dp = new int[101][100001];

  private static int solve(int n, int k, int[] weight, int[] value) {
    for(int i = 1; i <= n; i++){
      for(int j = 0; j <= k; j++) {
        if (weight[i] > j)
          dp[i][j] = dp[i-1][j];
        else
          dp[i][j] = Math.max(value[i] + dp[i-1][j-weight[i]], dp[i-1][j]);
      }
    }
    return dp[n][k];
  }

}
