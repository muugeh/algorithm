package math.boj;

// [수열의 합] https://www.acmicpc.net/problem/1024

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1024 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(st.nextToken());
    int l = Integer.parseInt(st.nextToken());
    int start = -1;
    boolean find = false;
    while (l <= 100) {
      for (start = 0; start < n; start++) {
        if (sum(start, l) == n) find = true;
        if (sum(start, l) >= n) break;
      }
      if (find) break;
      l++;
    }
    if (find) {
      for (int i = start; i <= start + l - 1; i++) {
        sb.append(i).append(" ");
      }
    } else {
      sb.append(-1);
    }
    System.out.println(sb);
    br.close();
  }

  private static int sum(int start, int l) {
    return (2 * start + l - 1) * l / 2;
  }
}
