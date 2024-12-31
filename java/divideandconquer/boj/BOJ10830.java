package divideandconquer.boj;

// [행렬 제곱] https://www.acmicpc.net/problem/10830

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10830 {

  private static final int MOD = 1000;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    long b = Long.parseLong(st.nextToken());

    int[][] a = new int[n][n];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        a[i][j] = Integer.parseInt(st.nextToken()) % MOD;
      }
    }

    StringBuilder sb = new StringBuilder();
    int[][] multiply = pow(a, b);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        sb.append(multiply[i][j]).append(" ");
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  private static int[][] pow(int[][] a, long b) {
    if (b == 1) return a;
    int[][] ret = pow(a, b / 2);
    ret = multiply(ret, ret);
    if (b % 2 == 1) {
      ret = multiply(ret, a);
    }
    return ret;
  }

  private static int[][] multiply(int[][] a1, int[][] a2) {
    int n = a1.length;
    int[][] ret = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < n; k++) {
          ret[i][j] += a1[i][k] * a2[k][j];
          ret[i][j] %= MOD;
        }
      }
    }
    return ret;
  }
}
