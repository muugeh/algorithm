package dp.boj;

// [가장 긴 바이토닉 부분 수열] https://www.acmicpc.net/problem/11054

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class BOJ11054 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] a = Arrays.stream(br.readLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
    int[] dp = new int[n];
    int[] left = new int[n];
    int[] right = new int[n];
    Arrays.fill(dp, 1);
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (a[i] > a[j]) {
          left[i] = Math.max(left[i], left[j] + 1);
        }
      }
      int reverse = n - (i + 1);
      for (int j = reverse + 1; j < n; j++) {
        if (a[reverse] > a[j]) {
          right[reverse] = Math.max(right[reverse], right[j] + 1);
        }
      }
    }
    for (int i = 0; i < n; i++) {
      dp[i] += left[i] + right[i];
    }

    bw.write(String.valueOf(Arrays.stream(dp).max().orElse(-1)));
    bw.flush();
    bw.close();
    br.close();
  }
}
