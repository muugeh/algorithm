package samsung.boj;

// [퇴사] https://www.acmicpc.net/problem/14501

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {

  private static int n;
  private static int[] times;
  private static int[] payments;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    times = new int[n + 1];
    payments = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int t = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());
      times[i] = t;
      payments[i] = p;
    }
    System.out.println(solve(1));
    br.close();
  }

  private static int solve(int time) {
    int maxPayment = 0;
    for (int i = time; i <= n; i++) {
      if (i + times[i] <= n + 1) {
        maxPayment = Math.max(maxPayment, solve(i + times[i]) + payments[i]);
      }
    }
    return maxPayment;
  }
}
