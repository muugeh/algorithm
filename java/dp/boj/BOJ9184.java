package dp.boj;

// [신나는 함수 실행] https://www.acmicpc.net/problem/9184

import java.io.*;
import java.util.StringTokenizer;

public class BOJ9184 {

  private static int[][][] cache = new int[21][21][21];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    StringBuilder sb = new StringBuilder();
    String line;
    while (!(line = br.readLine()).equals("-1 -1 -1")) {
      StringTokenizer st = new StringTokenizer(line);
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      sb.append("w(")
          .append(a).append(", ")
          .append(b).append(", ")
          .append(c).append(") = ")
          .append(w(a, b, c)).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
    br.close();
  }

  private static int w(int a, int b, int c) {
    if (a <= 0 || b <= 0 || c <= 0)
      return cache[0][0][0] = 1;

    if (a > 20 || b > 20 || c > 20)
      a = b = c = 20;

    for (int i = 0; i <= a; i++) {
      for (int j = 0; j <= b; j++) {
        for (int k = 0; k <= c; k++) {
          if (i == 0 || j == 0 || k == 0)
            cache[i][j][k] = 1;
          else if (i < j && j < k) {
            cache[i][j][k] = cache[i][j][k - 1] + cache[i][j - 1][k - 1] - cache[i][j - 1][k];
          } else {
            cache[i][j][k] = cache[i - 1][j][k] + cache[i - 1][j - 1][k] + cache[i - 1][j][k - 1] - cache[i - 1][j - 1][k - 1];
          }
        }
      }
    }
    return cache[a][b][c];
  }

}