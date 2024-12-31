package dp.boj;

// [포도주 시식] https://www.acmicpc.net/problem/2156

import java.io.*;
import java.util.Arrays;

public class BOJ2156 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] amount = new int[n];
    int[][] sum = new int[n][3];
    for (int i = 0; i < n; i++) {
      amount[i] = Integer.parseInt(br.readLine());
    }

    sum[0][1] = amount[0];
    for (int i = 1; i < n; i++) {
      if (i > 1)
        sum[i][0] = Arrays.stream(sum[i - 2]).max().orElse(0);

      sum[i][0] = Math.max(sum[i][0], Arrays.stream(sum[i - 1]).max().orElse(0));
      sum[i][1] = sum[i - 1][0] + amount[i];
      sum[i][2] = sum[i - 1][1] + amount[i];
    }
    bw.write(String.valueOf(Arrays.stream(sum[n - 1]).max().orElse(-1)));
    bw.flush();
    bw.close();
    br.close();
  }

}