package dp.boj;

// [동전 1] https://www.acmicpc.net/problem/2293

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2293 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] coins = new int[n + 1];
    int[] sum = new int[k + 1];
    sum[0] = 1;
    for (int i = 1; i <= n; i++) {
      coins[i] = Integer.parseInt(br.readLine());
      for (int j = coins[i]; j <= k; j++) {
        sum[j] += sum[j - coins[i]];
      }
    }
    System.out.println(sum[k]);
  }
}
