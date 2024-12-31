package dp.boj;

// [01타일] https://www.acmicpc.net/problem/1904

import java.io.*;

public class BOJ1904 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] dp = new int[n + 1];
    int init = Math.min(n, 2);
    for (int i = 0; i <= init; i++)
      dp[i] = i;
    for (int i = 3; i <= n; i++)
      dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
    bw.write(String.valueOf(dp[n]));
    bw.flush();
    bw.close();
    br.close();
  }

}
