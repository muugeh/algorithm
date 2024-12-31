package dp.boj;

// [1로 만들기] https://www.acmicpc.net/problem/1463

import java.io.*;

public class BOJ1463 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int x = Integer.parseInt(br.readLine());
    int[] dp = new int[x + 1];
    for (int i = 2; i <= x; i++) {
      if (i % 6 == 0)
        dp[i] = Math.min(dp[i / 3], dp[i / 2]) + 1;
      else if (i % 3 == 0)
        dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
      else if (i % 2 == 0)
        dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
      else
        dp[i] = dp[i - 1] + 1;
    }
    bw.write(String.valueOf(dp[x]));
    bw.flush();
    bw.close();
    br.close();
  }

}
