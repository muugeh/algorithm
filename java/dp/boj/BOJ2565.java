package dp.boj;

// [전깃줄] https://www.acmicpc.net/problem/2565

import java.io.*;
import java.util.*;

public class BOJ2565 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int n = Integer.parseInt(br.readLine());
    int[] cable = new int[501];
    int[] dp = new int[n];
    List<Integer> starts = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      cable[start] = end;
      starts.add(start);
    }
    Collections.sort(starts);
    for (int i = 0; i < n; i++) {
      int now = starts.get(i);
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        int before = starts.get(j);
        if (cable[now] > cable[before]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }
    bw.write(String.valueOf(n - Arrays.stream(dp).max().orElse(-1)));
    bw.flush();
    bw.close();
    br.close();
  }
}
