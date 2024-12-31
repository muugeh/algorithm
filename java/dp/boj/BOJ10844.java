package dp.boj;

// [쉬운 계단 수] https://www.acmicpc.net/problem/10844

import java.io.*;

public class BOJ10844 {

  private static int[][] floor = new int[101][10];

  private static final int MOD = 1_000_000_000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    init(n);
    bw.write(String.valueOf(sum(n)));
    bw.flush();
    bw.close();
    br.close();
  }

  private static void init(int n) {
    for (int i = 1; i < 10; i++)
      floor[1][i] = 1;
    for (int i = 2; i <= n; i++) {
      floor[i][0] = floor[i - 1][1] % MOD;
      for (int j = 1; j <= 8; j++)
        floor[i][j] = (floor[i - 1][j - 1] + floor[i - 1][j + 1]) % MOD;
      floor[i][9] = floor[i - 1][8] % MOD;
    }
  }

  private static int sum(int n){
    int sum = 0;
    for(int i = 0; i <= 9; i++)
      sum = (sum + floor[n][i]) % MOD;
    return sum;
  }

}
