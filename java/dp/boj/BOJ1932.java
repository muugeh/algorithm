package dp.boj;

// [정수 삼각형] https://www.acmicpc.net/problem/1932

import java.io.*;
import java.util.StringTokenizer;

public class BOJ1932 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int max = 0;
    int[] before = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int[] sum = new int[n + 1];
      for (int j = 1; j <= i; j++) {
        sum[j] = Math.max(before[j - 1], before[j]) + Integer.parseInt(st.nextToken());
        max = Math.max(max, sum[j]);
      }
      before = sum;
    }
    bw.write(String.valueOf(max));
    bw.flush();
    bw.close();
    br.close();
  }

}
