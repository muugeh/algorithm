package dp.boj;

// [조합] https://www.acmicpc.net/problem/2407

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ2407 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    bw.write(combination(n, m).toString());
    bw.flush();
    bw.close();
    br.close();
  }

  private static final BigInteger[][] pascal = new BigInteger[101][101];

  private static BigInteger combination(int n, int m) {
    pascal[1][0] = pascal[1][1] = new BigInteger("1");
    for (int i = 2; i <= n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0 || j == i) {
          pascal[i][j] = new BigInteger("1");
          continue;
        }
        pascal[i][j] = new BigInteger(pascal[i - 1][j].add(pascal[i - 1][j - 1]).toString());
      }
    }
    return pascal[n][m];
  }
}
