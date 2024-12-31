package backtracking.boj;

// [스타트와 링크] https://www.acmicpc.net/problem/14889

import java.io.*;
import java.util.StringTokenizer;

public class BOJ14889 {

  private static int[][] team;
  private static boolean[] picked;
  private static int n;
  private static int min = Integer.MAX_VALUE;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    team = new int[n][n];
    picked = new boolean[n];
    for (int i = 0; i < n; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < n; j++) {
        team[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    dfs(0, 0);
    System.out.println(min);
  }

  private static void dfs(int depth, int index) {
    if (depth == n / 2) {
      difference();
      return;
    }

    for (int i = index; i < n; i++) {
      if (!picked[i]) {
        picked[i] = true;
        dfs(depth + 1, i + 1);
        picked[i] = false;
      }
    }
  }

  private static void difference() {
    int start = 0;
    int link = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        if (picked[i] && picked[j])
          start += team[i][j] + team[j][i];
        else if (!picked[i] && !picked[j])
          link += team[i][j] + team[j][i];
      }
    }
    int val = Math.abs(start - link);
    if (val == 0) {
      System.out.println(val);
      System.exit(0);
    }
    min = Math.min(min, val);
  }

}
