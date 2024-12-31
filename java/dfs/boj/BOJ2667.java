package dfs.boj;

// [단지번호붙이기] https://www.acmicpc.net/problem/2667

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ2667 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    house = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      String row = br.readLine();
      for (int j = 0; j < n; j++) {
        if (row.charAt(j) == '1') {
          house[i][j] = true;
        }
      }
    }
    search(0, 0);
    System.out.println(villages.size());
    Collections.sort(villages);
    for (Integer village : villages) System.out.println(village);
  }

  private static int n;
  private static List<Integer> villages = new ArrayList<>();
  private static final int[] dx = {1, -1, 0, 0};
  private static final int[] dy = {0, 0, -1, 1};
  private static boolean[][] visited;
  private static boolean[][] house;

  private static void dfs(int row, int col) {
    visited[row][col] = true;
    villages.set(villages.size() - 1, villages.get(villages.size() - 1) + 1);

    for (int k = 0; k < 4; k++) {
      int nx = dx[k] + row;
      int ny = dy[k] + col;
      if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
        if (!visited[nx][ny] && house[nx][ny]) {
          dfs(nx, ny);
        }
      }
    }
  }

  private static void search(int row, int col) {
    for (int i = row; i < n; i++)
      for (int j = col; j < n; j++) {
        if (!visited[i][j]) {
          visited[i][j] = true;
          if (house[i][j]) {
            villages.add(0);
            dfs(i, j);
          }
        }
      }
  }
}


