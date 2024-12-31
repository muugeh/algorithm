package graph.boj;

// [플로이드] https://www.acmicpc.net/problem/11404

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11404 {

  private static int[][] map;
  private static int n;
  private static final int INF = 100000 * 100 + 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    map = new int[n + 1][n + 1];
    for (int[] row : map) Arrays.fill(row, INF);
    int m = Integer.parseInt(br.readLine());
    for (int i = 0; i < m; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      map[a][b] = Math.min(map[a][b], c);
    }

    floyd();

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        System.out.print(map[i][j] == INF ? 0 : map[i][j] + " ");
      }
      System.out.println();
    }
  }

  private static void floyd() {
    for (int i = 0; i <= n; i++) map[i][i] = 0;

    for (int k = 1; k <= n; k++) {
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
          map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
        }
      }
    }
  }
}
