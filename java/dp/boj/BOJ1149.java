package dp.boj;

// [RGB거리] https://www.acmicpc.net/problem/1149

import java.io.*;
import java.util.Arrays;

public class BOJ1149 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[][] dp = new int[n][3];
    int[][] color = new int[n][3];
    for (int i = 0; i < n; i++) {
      color[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    System.arraycopy(color[0], 0, dp[0], 0, 3);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < 3; j++) {
        dp[i][j] = Math.min(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]) + color[i][j];
      }
    }

    int min = Arrays.stream(dp[n - 1]).min().getAsInt();
    bw.write(String.valueOf(min));
    bw.flush();
    bw.close();
    br.close();
  }

}
